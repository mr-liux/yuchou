package com.youzi.yuchou.admin.web.system;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.admin.service.system.SysUserService;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.web.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "API - SysUserController", description = "后台用户信息处理")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService userService;
	
	
	@ApiOperation(value = "新增用户信息",notes="通过body传入新增用户信息", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "APIKEY",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PostMapping("/")
	public RestResponse<String> add(@RequestHeader String APIKEY,@RequestBody SysUsers users){
		userService.add(users);
		return buildDefaultSuccessed("新增成功");
	}

	
	
	
	@ApiOperation(value = "删除用户信息", notes="根据url的id来删除用户信息",httpMethod = "DELETE", response = RestResponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType="path"),
		@ApiImplicitParam(name = "APIKEY",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@DeleteMapping("/{id}")
	public RestResponse<String> delete(@RequestHeader String APIKEY,@PathVariable Integer id) {
		userService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	
	
	
	@ApiOperation(value = "修改用户信息",notes="根据表单传入的User对象来修改用户信息", httpMethod = "PUT", response = RestResponse.class)
	@ApiImplicitParam(name = "APIKEY",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PutMapping("/")
	public RestResponse<String> update(@RequestHeader String APIKEY, @RequestBody SysUsers users) {
		userService.update(users);
		return buildDefaultSuccessed("修改成功");
	}
	
	
	
	
	@ApiOperation(value = "查询用户信息",notes="根据url的id查询用户信息", httpMethod = "GET", response = SysUsers.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="用户id",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "APIKEY",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@GetMapping("/{id}")
	public SysUsers findById(@RequestHeader String APIKEY,@PathVariable Integer id) {
		return userService.findById(id);
	}

	
	
	@ApiOperation(value = "分页条件查找用户信息",notes="分页条件查找用户信息", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value="姓名",required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userId", value="用户名",required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "companyKy",value="公司ID",required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "APIKEY",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@GetMapping("/list")
	public RestResponse<Object> findAll(@RequestHeader String APIKEY,HttpServletRequest request) throws Exception{
		logger.info(APIKEY);
		RestResponse<Object> page = userService.findAll(new PageInfo(request.getParameterMap()));
		return page;
	}
}
