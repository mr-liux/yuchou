package com.youzi.yuchou.module.mvc.login.service.intf;

import com.youzi.yuchou.module.mvc.login.domain.User;

public interface TokenServiceIntf {
	

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
