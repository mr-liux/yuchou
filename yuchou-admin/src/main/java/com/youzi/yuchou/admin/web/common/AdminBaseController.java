package com.youzi.yuchou.admin.web.common;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.youzi.yuchou.admin.service.common.BaseUserService;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.web.BaseController;

public class AdminBaseController extends BaseController {
	
	@Autowired
	private BaseUserService userTokenService;
	
	public SysUsers getUser(HttpServletRequest request){
		return userTokenService.getUser(request);
	}
	
	public Integer getLoginUid(HttpServletRequest request){
		return getUser(request).getUserKy();
	}

}
