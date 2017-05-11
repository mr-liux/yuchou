package com.youzi.yuchou.admin.web.system;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.admin.service.system.SysJobService;
import com.youzi.yuchou.admin.web.common.AdminBaseController;
import com.youzi.yuchou.module.model.model.SysJob;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "API - SysJobController", description = "后台岗位信息处理")
@RestController
@RequestMapping("/admin/system/job")
public class SysJobController extends AdminBaseController {

	@Autowired
	private SysJobService jobService;
	
	
	@ApiOperation(value = "新增岗位信息",notes="通过body传入新增岗位信息", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@PostMapping("/")
	public RestResponse<String> add(@RequestBody SysJob company){
		jobService.add(company);
		return buildDefaultSuccessed("新增成功");
	}

	
	
	
	@ApiOperation(value = "删除岗位信息", notes="根据url的id来删除岗位信息",httpMethod = "DELETE", response = RestResponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "岗位ID", required = true, dataType = "Long", paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@Auth 
	@DeleteMapping("/{id}")
	public RestResponse<String> delete(@PathVariable Integer id) {
		jobService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	
	
	
	@ApiOperation(value = "修改岗位信息",notes="根据表单传入的User对象来修改岗位信息", httpMethod = "PUT", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@PutMapping("/")
	public RestResponse<String> update( @RequestBody SysJob users) {
		jobService.update(users);
		return buildDefaultSuccessed("修改成功");
	}
	
	
	
	
	@ApiOperation(value = "查询岗位信息",notes="根据url的id查询岗位信息", httpMethod = "GET", response = SysJob.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="岗位id",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@Auth 
	@GetMapping("/{id}")
	public SysJob findById(@PathVariable Integer id) {
		return jobService.findById(id);
	}

	
	
	@ApiOperation(value = "分页条件查找岗位信息",notes="分页条件查找岗位信息", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value="岗位名称",required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@Auth 
	@GetMapping("/list")
	public RestResponse<Object> findAll(HttpServletRequest request) throws Exception{
		RestResponse<Object> page = jobService.findAll(new PageInfo(request.getParameterMap()));
		return page;
	}
}
