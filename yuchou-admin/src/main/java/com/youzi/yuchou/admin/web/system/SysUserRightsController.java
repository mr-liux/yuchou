package com.youzi.yuchou.admin.web.system;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.admin.web.common.AdminBaseController;
import com.youzi.yuchou.admin.web.system.domain.request.UserRightsRequest;
import com.youzi.yuchou.admin.web.system.domain.response.TreeEntityResponse;
import com.youzi.yuchou.admin.service.system.SysUserRightsService;
import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "API - SysUserRightsController", description = "后台权限处理接口")
@RestController
@RequestMapping("/admin/system/right")
public class SysUserRightsController extends AdminBaseController {

	@Autowired
	private SysUserRightsService rightsService;
	
	
	@ApiOperation(value = "分配用户权限信息",notes="通过body传入给用户分配权限", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@PostMapping("/")
	public RestResponse<String> add(@RequestBody UserRightsRequest rightsRequest ,HttpServletRequest request){
		rightsService.update(rightsRequest.getUserKy(),rightsRequest.getMenuIds(),super.getLoginUid(request));
		return buildDefaultSuccessed("权限分配成功");
	}

	

	
	
	@ApiOperation(value = "查询我的权限菜单，用于ztree.js",notes="根据url的id查询用户菜单权限树状菜单信息", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@Auth 
	@GetMapping("/myTreeMenu")
	public RestResponse<List<TreeEntityResponse>> findById( HttpServletRequest request) {
		return RestResponse.buildSuccessed(rightsService.queryMyRightsTreeMenu(super.getLoginUid(request)));
	}
	
	@ApiOperation(value = "获取我的菜单列表",notes="获取我的菜单列表", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@GetMapping("/myMenu")
	public RestResponse<Object> findAll(HttpServletRequest request){
		RestResponse<Object> page = rightsService.getMyMenu(super.getLoginUid(request));
		return buildSuccessed(page);
	}
	

}
