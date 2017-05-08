package com.youzi.yuchou.admin.web.system;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.module.mvc.common.LocalStaticValue;
import com.youzi.yuchou.module.mvc.login.domain.LoginCommand;
import com.youzi.yuchou.module.mvc.login.domain.TokenResponse;
import com.youzi.yuchou.module.mvc.login.service.TokenService;
import com.youzi.yuchou.module.mvc.utils.NetworkUtils;
import com.youzi.yuchou.module.mvc.web.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API - LoginAdminController", description = "获取后台登录口令接口")
@RestController
@RequestMapping("/admin")
public class LoginAdminController extends BaseController {

	@Autowired
	private TokenService tokenService;
	
	
	@ApiOperation(value = "后台管理员登录",notes="通过body传入用户名密码获取token信息", httpMethod = "POST", response = TokenResponse.class)
	@PostMapping("/login")
	public TokenResponse login(@RequestBody LoginCommand user,HttpServletRequest request){
		return new TokenResponse(LocalStaticValue.SUCCESS+"",tokenService.getToken(user, NetworkUtils.getIpAddress(request)));
	}

	
	

}
