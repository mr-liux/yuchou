package com.youzi.yuchou.admin.common.login.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.youzi.yuchou.admin.common.login.UserTokenManager;
import com.youzi.yuchou.admin.common.login.domain.LoginCommand;
import com.youzi.yuchou.admin.common.login.domain.TokenInfo;
import com.youzi.yuchou.admin.common.login.domain.User;
import com.youzi.yuchou.admin.common.login.service.intf.TokenRightServiceIntf;
import com.youzi.yuchou.admin.common.login.service.intf.TokenUserServiceIntf;
import com.youzi.yuchou.core.exception.AuthException;
import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.module.mvc.utils.CommonUtils;
import com.youzi.yuchou.module.mvc.utils.MD5Util;

@Component
public class TokenService {

	private static Logger log = Logger.getLogger(TokenService.class);
	@Autowired
	private TokenUserServiceIntf tokenServiceIntf;
	@Autowired
	private TokenRightServiceIntf rightServiceIntf;
	

	
	// 判断用户登录用户名密码是否正确
	private Boolean checkUserExists(LoginCommand loginCommand, User user)
			 {

		Boolean result = false;
		if (user == null) {
			throw new AuthException(
					ExceptionStaticEnum.ERROR_NO_INVALID_USER.getCode(),
					ExceptionStaticEnum.ERROR_NO_INVALID_USER.getMessage());
		}
		if (user.getStatus().intValue() != 1) {
			throw new AuthException(
					ExceptionStaticEnum.ERROR_USER_IS_UNABLE.getCode(),
					ExceptionStaticEnum.ERROR_USER_IS_UNABLE.getMessage());
		}
		int nErrorCount = 0;
		if(UserTokenManager.startErrorLocked){
			if (user.getLastLoginNum() != null) {
				nErrorCount = user.getLastLoginNum().intValue();
			}
			// 判断用户登录是否在锁定状态
			if (nErrorCount >= UserTokenManager.errorCountLimit) {
				Long loginLockedTime = user.getLoginLockedTime();
				int nMins = (int) (System.currentTimeMillis() - loginLockedTime)/ (1000 * 60);
				if (nMins < UserTokenManager.errorLoginLockedTime) {
					throw new AuthException(ExceptionStaticEnum.USER_LOGIN_LOCKED.getCode(),
							ExceptionStaticEnum.USER_LOGIN_LOCKED.getMessage());
				} else {
					user.setErrorCount(0);
					tokenServiceIntf.modifyUser(user);
				}
			}
		}
		if (!MD5Util.MD5(loginCommand.getPassword()).equals(user.getPassword())) {
			if(UserTokenManager.startErrorLocked){
				nErrorCount++;
				user.setErrorCount(nErrorCount);
				if (nErrorCount == UserTokenManager.errorCountLimit) {
					long LockedTime = System.currentTimeMillis();
					user.setLoginLockedTime(LockedTime);
					tokenServiceIntf.modifyUser(user);
					throw new AuthException(ExceptionStaticEnum.USER_LOGIN_LOCKED.getCode(),
							ExceptionStaticEnum.USER_LOGIN_LOCKED.getMessage());
				} else {
					tokenServiceIntf.modifyUser(user);
				}
			}
			throw new  AuthException(
					ExceptionStaticEnum.ERROR_NO_INVALID_USER.getCode(),
					ExceptionStaticEnum.ERROR_NO_INVALID_USER.getMessage());
		} else {
			result = true;
		}
		if (user.getErrorCount() == null || user.getErrorCount() > 0) {
			user.setErrorCount(0);
			tokenServiceIntf.modifyUser(user);
		}
		return result;
	}

	/**
	 * 生成sessionID
	 * @param token
	 * @param ip
	 * @return
	 */
	public static String getSessionId(String token,String  ip){
		return MD5Util.MD5(token+ip);
	}
	
	
	/**
	 * 获取用户token
	 * @param loginCommand
	 * @return
	 * @throws Exception
	 */
	public String getToken(LoginCommand loginCommand,String ip)  {
		log.info("getToken enter.");
		long currTime = System.currentTimeMillis();
		User user = tokenServiceIntf
				.queryUserByCode(loginCommand.getUserCode());
		if (!checkUserExists(loginCommand, user)) {
			return null;
		}
		if(UserTokenManager.startErrorLocked){
			user.setLastLoginTime(currTime);
			user.setIsLogin(true);
			tokenServiceIntf.modifyUser(user);
		}
		// 使用用户名及密码生成
		String token = 	CommonUtils.getUUID();
		// 先判断UUID是否存在，保证不会重复
		if (UserTokenManager.userTokenMap.get(token) != null) {
			token = CommonUtils.getUUID();
		}
		//如果当前用户已经登录 则清除登录的用户，保证一个用户只能登陆一次
		UserTokenManager.clearUserToken(user.getUserKy().longValue());
		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setUid(user.getUserKy().longValue());
		tokenInfo.setSid(ip);
		tokenInfo.setFirstVisitTime(currTime);
		tokenInfo.setLastVisitTime(currTime);
		UserTokenManager.userTokenMap.put(token, tokenInfo);
		// 获取用户的权限，保存到内存中
		if (UserTokenManager.userRightMap.get(user.getUserKy()) == null) {
			
		}
		List<Integer> rights = UserTokenManager.userRightMap.get(user.getUserKy());
		if (rights == null) {
			rights = rightServiceIntf.queryUserRights(user.getUserKy());
			UserTokenManager.userRightMap.put(user.getUserKy(), rights);
		}
		/*LoginResponse response = new LoginResponse();
		response.setLoginResult(0);
		response.setUserCode(user.getUserId());
		response.setToken(token);
		List<String> rightList = new ArrayList<String>();
		response.setRightList(rightList);*/
		return token;
	}

	
	// 根据token获取用户权限数据
/*	@Override
	public RoleRightDetail queryRightByToken(String token) throws Exception {

		if (UserToken.userTokenMap.get(token) == null) {
			throw new BusinessException(ErrorMenu.ERROR_NO_NO_INVALID_TOKEN);
		}
		TokenInfo tokenInfo = UserToken.userTokenMap.get(token);
		if (UserToken.userRoleMap.get(tokenInfo.getUserId()) == null) {
			throw new BusinessException(ErrorMenu.ERROR_NO_NO_INVALID_TOKEN);
		}
		User user = UserToken.userRoleMap.get(tokenInfo.getUserId());
		if (UserToken.roleRightMap.get(user.getRoleId()) == null) {
			throw new BusinessException(ErrorMenu.ERROR_NO_NO_INVALID_TOKEN);
		}
		RoleRightDetail rightDetail = UserToken.roleRightMap.get(user
				.getRoleId());

		return rightDetail;
	}

	// 根据token获取用户权限数据
	@Override
	public Long queryUserIdByToken(String token) throws Exception {

		TokenInfo tokenInfo = UserToken.userTokenMap.get(token);
		if (tokenInfo == null) {
			throw new BusinessException(ErrorMenu.ERROR_NO_NO_INVALID_TOKEN);
		}
		return tokenInfo.getUserId();
	}





	// 判断token是否存在有效权限
	@Override
	public boolean checkTokenRightValid(String token, String rightCode)
			throws Exception {

		RoleRightDetail rightDetail = queryRightByToken(token);
		for (RightInfo right : rightDetail.getRightList()) {
			if (right.getRightCode().startsWith(rightCode)) {
				updateTokenLastTime(token);
				return true;
			}
		}
		return false;
	}

*/

}
