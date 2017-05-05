package com.youzi.yuchou.module.mvc.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youzi.yuchou.module.mvc.login.domain.TokenInfo;

//用户Token管理数据
public class UserToken {
	public static String TOKEN_LOCK = "token_lock";

	// 保存token和用户id的字典数据
	public static Map<String, TokenInfo> userTokenMap = new HashMap<String, TokenInfo>();


	/**
	 * 判断Token是否有效
	 * @param token
	 * @throws Exception
	 */
	public static boolean checkTokenValid(String token) throws Exception {

		TokenInfo tokenInfo = UserToken.userTokenMap.get(token);
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
	public static void removeToken(String token) throws Exception {
		synchronized (TOKEN_LOCK) {
			TokenInfo tokenInfo = userTokenMap.get(token);
			if (tokenInfo != null) {
				UserToken.userTokenMap.remove(token);
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

		Collection<TokenInfo> userList = UserToken.userTokenMap.values();
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
			UserToken.userTokenMap.remove(key);
		}
	}
	
	
}
