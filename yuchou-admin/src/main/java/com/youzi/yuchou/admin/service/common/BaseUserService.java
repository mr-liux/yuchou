package com.youzi.yuchou.admin.service.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.common.login.UserTokenManager;
import com.youzi.yuchou.admin.common.login.domain.TokenInfo;
import com.youzi.yuchou.admin.service.system.SysUserService;
import com.youzi.yuchou.core.exception.AuthException;
import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.common.LocalStaticValue;
@Service
public class BaseUserService extends AdminBaseService {
	@Autowired
	private SysUserService userService;
	
	/**
	 * 获取用户对象
	 * @param request
	 * @return
	 */
	public SysUsers getUser(HttpServletRequest request){
		SysUsers users = null;
		String token = request.getHeader(LocalStaticValue.AUTH_TOKEN);
		if(token==null){
			throw new AuthException(
					ExceptionStaticEnum.ERROR_NO_LOGIN.getCode(),
					ExceptionStaticEnum.ERROR_NO_LOGIN.getMessage());
		}else{
			TokenInfo tokenInfo = UserTokenManager.userTokenMap.get(token);
			if(tokenInfo==null){
				throw new AuthException(
						ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN.getCode(),
						ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN.getMessage());
			}else{
				 users = userService.findById(tokenInfo.getUid().intValue());
			}
		}
		
		return users;
		
	}


}
