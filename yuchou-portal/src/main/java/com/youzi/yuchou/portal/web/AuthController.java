package com.youzi.yuchou.portal.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.web.BaseController;

@RestController
public class AuthController extends BaseController {

	/**
	 * 权限验证示例 -- 需要登录
	 * 
	 * @return
	 */
	@Auth
	@GetMapping("/auth")
	public RestResponse<String> auth() {
		return buildDefaultSuccessed("通过权限验证");
	}

	/**
	 * 权限验证示例 -- 需要管理员权限
	 * 
	 * @return
	 */
	@Auth(roles = { "admin" })
	@GetMapping("/auth/role")
	public RestResponse<String> authRoles() {
		return buildDefaultSuccessed("通过权限验证");
	}

	/**
	 * 权限验证示例 -- 需要A资源权限
	 * 
	 * @return
	 */
	@Auth(authorities = { "A" })
	@GetMapping("/auth/authorities")
	public RestResponse<String> authAuthorities() {
		return buildDefaultSuccessed("通过权限验证");
	}

}
