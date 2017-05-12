package com.youzi.yuchou.admin.web.system;


import java.util.List;

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

import com.youzi.yuchou.admin.service.system.SysCompanyService;
import com.youzi.yuchou.admin.web.common.AdminBaseController;
import com.youzi.yuchou.module.model.model.SysCompany;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.dto.TreeNode;
import com.youzi.yuchou.module.mvc.form.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "API - SysCompanyController", description = "后台公司信息处理")
@RestController
@RequestMapping("/admin/system/company")
public class SysCompanyController extends AdminBaseController {

	@Autowired
	private SysCompanyService companyService;
	
	
	@ApiOperation(value = "新增公司信息",notes="通过body传入新增公司信息", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@PostMapping("/")
	public RestResponse<String> add(@RequestBody SysCompany company){
		companyService.add(company);
		return buildDefaultSuccessed("新增成功");
	}

	
	
	
	@ApiOperation(value = "删除公司信息", notes="根据url的id来删除公司信息",httpMethod = "DELETE", response = RestResponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "公司ID", required = true, dataType = "Long", paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@Auth 
	@DeleteMapping("/{id}")
	public RestResponse<String> delete(@PathVariable Integer id) {
		companyService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	
	
	
	@ApiOperation(value = "修改公司信息",notes="根据表单传入的User对象来修改公司信息", httpMethod = "PUT", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@Auth 
	@PutMapping("/")
	public RestResponse<String> update( @RequestBody SysCompany users) {
		companyService.update(users);
		return buildDefaultSuccessed("修改成功");
	}
	
	
	
	
	@ApiOperation(value = "查询公司信息",notes="根据url的id查询公司信息", httpMethod = "GET", response = SysCompany.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="公司id",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@Auth 
	@GetMapping("/{id}")
	public SysCompany findById(@PathVariable Integer id) {
		return companyService.findById(id);
	}

	
	
	@ApiOperation(value = "分页条件查找公司信息",notes="分页条件查找公司信息", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条,如果将此参数设置为-1，则查询全部",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value="公司名",required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@Auth 
	@GetMapping("/list")
	public RestResponse<Object> findAll(HttpServletRequest request) throws Exception{
		RestResponse<Object> page = companyService.findAll(new PageInfo(request.getParameterMap()));
		return page;
	}
	
	
	@ApiOperation(value = "获取公司树状菜单",notes="获取公司树状菜单", httpMethod = "GET", response = List.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "cpage", value="当前页",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "pagesize", value="每页显示几条,如果将此参数设置为-1，则查询全部",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@Auth 
	@GetMapping("/treeList")
	public List<TreeNode> treeList(HttpServletRequest request) throws Exception{
		return companyService.getTreeNode(new PageInfo(request.getParameterMap()));
	}
}
