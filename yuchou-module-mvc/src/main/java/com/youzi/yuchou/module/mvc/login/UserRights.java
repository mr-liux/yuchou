package com.youzi.yuchou.module.mvc.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youzi.yuchou.module.mvc.login.domain.TokenInfo;

public class UserRights {
	
	//保存角色的权限数据
	public static Map<Long, Object> userRightMap = new HashMap<Long, Object>();
	
	/*// 获取当前token的权限列表
	 public static List<String> getTokenRightList(String token)
	{
			List<String> rightCodeList = new ArrayList<String>();
			TokenInfo tokenInfo = UserToken.userTokenMap.get(token);
			if (tokenInfo == null)
			{
				return rightCodeList;
			}
			RoleRightDetail rightDetail = userRightMap.get(user.getRoleId());

			for (RightInfo right : rightDetail.getRightList())
			{
				rightCodeList.add(right.getRightCode());
			}
			return rightCodeList;
	 }*/
}
