package com.youzi.yuchou.admin.common.login.service.intf;

import com.youzi.yuchou.admin.common.login.domain.User;



public interface TokenUserServiceIntf {
	

	/**
	 * 通过用户名查询用户信息
	 * @param userCode
	 * @return
	 */
	public User queryUserByCode(String userCode);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean modifyUser(User user);


}
