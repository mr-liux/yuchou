package com.youzi.yuchou.admin.common.login.service.intf;

import java.util.List;


public interface TokenRightServiceIntf {
	


	/**
	 * 获取用户权限集合
	 * @param userKy
	 * @return
	 */
	public List<Integer> queryUserRights(Integer userKy);

}
