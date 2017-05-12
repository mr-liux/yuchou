package com.youzi.yuchou.admin.web.common;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.youzi.yuchou.admin.service.common.BaseUserService;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.web.BaseController;

public class AdminBaseController extends BaseController {
	
	@Autowired
	private BaseUserService userTokenService;
	/**
	 * 获取token user对象
	 * @author 背包
	 * @param request
	 * @return
	 */
	public SysUsers getUser(HttpServletRequest request){
		return userTokenService.getUser(request);
	}
	
	/**
	 * 获取token userKy
	 * @author 背包
	 * @param request
	 * @return
	 */
	public Integer getLoginUid(HttpServletRequest request){
		return userTokenService.getTokenUserKy(request);
	}

}
