package com.youzi.yuchou.admin.common.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youzi.yuchou.admin.common.login.domain.TokenInfo;



//用户Token管理数据
public class UserTokenManager {
	public static String TOKEN_LOCK = "token_lock";

	// 保存token和用户id的字典数据
	public static Map<String, TokenInfo> userTokenMap = new HashMap<String, TokenInfo>();
	//保存角色的权限数据
	public static Map<Integer, List<Integer>> userRightMap = new HashMap<Integer, List<Integer>>();

	public  static boolean startErrorLocked=false; //是否启用登录失败超过设置的次数则限制登录
	public  static int errorLoginLockedTime = 5;  //连续登录错误次数超过设置次数则锁定，锁定时间
	public  static int errorCountLimit = 3;	//连续登录错误次数超过设置值则锁定账号
	public  static int sessionTimeOut =600;   //session超时时间   单位秒
	
	public static TokenInfo getToken(String token){
		return userTokenMap.get(token);
	}
	
	/**
	 * 判断Token是否有效
	 * @param token
	 * @throws Exception
	 */
	public static boolean checkTokenValid(String token) throws Exception {

		TokenInfo tokenInfo = UserTokenManager.userTokenMap.get(token);
		if (tokenInfo == null) {
			return false;
		}
		return true;
	}

	/**
	 * 更新token最后访问时间
	 * 
	 * @param token
	 * @throws Exception
	 */
	public static void updateTokenLastTime(String token) throws Exception {
		synchronized (TOKEN_LOCK) {
			TokenInfo tokenInfo = userTokenMap.get(token);
			if (tokenInfo != null) {
				tokenInfo.setLastVisitTime(System.currentTimeMillis());
			}
		}
	}

	/**
	 * 更新token第一次访问时间
	 * 
	 * @param token
	 * @throws Exception
	 */
	public static void updateTokenFirstTime(String token) throws Exception {
		synchronized (TOKEN_LOCK) {
			TokenInfo tokenInfo = userTokenMap.get(token);
			if (tokenInfo != null) {
				tokenInfo.setFirstVisitTime(System.currentTimeMillis());
			}
		}
	}
	
	/**
	 * 清除当前token
	 * 
	 * @param token
	 * @throws Exception
	 */
	public static void removeToken(String token)  {
		synchronized (TOKEN_LOCK) {
			TokenInfo tokenInfo = userTokenMap.get(token);
			if (tokenInfo != null) {
				UserTokenManager.userTokenMap.remove(token);
			}
		}
	}

	/**
	 * 验证用户token是否存在
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static boolean checkUserLogined(Long userId) throws Exception {

		Collection<TokenInfo> userList = UserTokenManager.userTokenMap.values();
		for (TokenInfo token : userList) {
			// 用户存在token
			if (userId.equals(token.getUid())) {
				return true;
			}
		}
		return false;
	}

	// 清除用户相关Token信息
	public static void clearUserToken(Long userId) {

		List<String> removeList = new ArrayList<String>();
		for (String key : userTokenMap.keySet()) {
			if (userTokenMap.get(key).getUid().equals(userId)) {
				removeList.add(key);
			}
		}
		for (String key : removeList) {
			UserTokenManager.userTokenMap.remove(key);
		}
	}
	

	
}
