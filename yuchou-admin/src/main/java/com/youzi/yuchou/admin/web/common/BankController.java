package com.youzi.yuchou.admin.web.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

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

import com.youzi.yuchou.admin.service.common.BankService;
import com.youzi.yuchou.module.model.condition.CommonKeyWordCondition;
import com.youzi.yuchou.module.model.model.Bank;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.web.BaseController;

@Api(value = "API - BankController", description = "后台用户银行卡字典管理")
@RequestMapping("/admin")
@RestController
public class BankController extends BaseController {

	@Autowired
	BankService bankService;

	@Auth 
	@ApiOperation(value = "新增银行卡字典信息",notes="通过body传入新增信息", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PostMapping("/bank")
	public RestResponse<String> add(@RequestBody Bank bank){
		bankService.add(bank);
		return buildDefaultSuccessed("新增成功");
	}

	@DeleteMapping("/bank/{id}")
	public RestResponse<String> delete(@PathVariable Integer id) {
		bankService.delete(id);
		return buildDefaultSuccessed("删除成功");
	}

	@PutMapping("/bank")
	public RestResponse<String> update(@RequestBody Bank bank) {
		bankService.update(bank);
		return buildDefaultSuccessed("修改成功");
	}

	@Auth 
	@ApiOperation(value = "查询银行卡字典",notes="根据url的id查询用户信息", httpMethod = "GET", response = SysUsers.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="用户id",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@GetMapping("/bank/{id}")
	public RestResponse<Object> findById(@PathVariable Integer id) {
		RestResponse<Object> page = bankService.findById(id);
		return page;
	}
	/**
	 * 分页查询 银行卡字典
	 * @author 
	 * @return
	 * @throws Exception
	 * 
	 */
	@Auth 
	@ApiOperation(value = "分页条件查找银行卡字典",notes="分页条件查找银行卡字典", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@GetMapping("/bank/pagelist")
	public RestResponse<Object> pagebanklist(HttpServletRequest request) throws Exception{
		RestResponse<Object> page = bankService.findPage(new PageInfo(request.getParameterMap()));
		return page;
	}
	/**
	 * 查询银行卡字典集合信息
	 * @author 
	 * @return
	 * @throws Exception
	 * 
	 */
	@Auth 
	@ApiOperation(value = "查询银行卡字典集合信息",notes="通过body传入查询类型", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@GetMapping("/banklist/{type}")
	public RestResponse<Object> querylistAll(@PathVariable String type) throws Exception{
		RestResponse<Object> page = bankService.querylistAll(type);
		return page;
	}
}
