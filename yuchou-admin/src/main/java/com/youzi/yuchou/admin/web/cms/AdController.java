package com.youzi.yuchou.admin.web.cms;

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

import com.youzi.yuchou.admin.service.cms.AdService;
import com.youzi.yuchou.admin.service.common.BankService;
import com.youzi.yuchou.admin.web.common.AdminBaseController;
import com.youzi.yuchou.module.model.condition.CommonKeyWordCondition;
import com.youzi.yuchou.module.model.model.Ad;
import com.youzi.yuchou.module.model.model.Bank;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.web.BaseController;

@Api(value = "API - AdController", description = "后台广告")
@RequestMapping("/admin")
@RestController
public class AdController extends AdminBaseController {

	@Autowired
	AdService adService;

	@Auth 
	@ApiOperation(value = "新增广告信息",notes="通过body传入新增信息", httpMethod = "POST", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PostMapping("/ad/insert")
	public RestResponse<String> add(@RequestBody Ad ad,HttpServletRequest request){
		ad.setUserKy(super.getLoginUid(request));
		adService.add(ad);
		return buildDefaultSuccessed("新增成功");
	}
	
	@Auth 
	@ApiOperation(value = "删除广告信息",notes="通过body传入id信息状态删除", httpMethod = "DELDTE", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@DeleteMapping("/ad/upddel/{id}")
	public RestResponse<String> updDelete(@PathVariable Integer id) {
		adService.updDelete(id);
		return buildDefaultSuccessed("删除成功");
	}
	@Auth 
	@ApiOperation(value = "修改广告信息",notes="通过body传入信息", httpMethod = "PUT", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PutMapping("/ad/update")
	public RestResponse<String> update(@RequestBody Ad ad) {
		if(adService.update(ad)){
			return buildDefaultSuccessed("修改成功");
		}else{
			return buildFailed(1000,"修改失败");
		}
	}
	@Auth 
	@ApiOperation(value = "修改广告信息状态（0删除，1待发布，2已发布）",notes="通过body传入信息", httpMethod = "PUT", response = RestResponse.class)
	@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	@PutMapping("/ad/updstatus")
	public RestResponse<Object> updStatus(@RequestBody Ad ad) {
		RestResponse<Object> page = adService.updStatus(ad);
		return page;
	}

	@Auth 
	@ApiOperation(value = "查询广告",notes="根据url的id查询信息", httpMethod = "GET", response = SysUsers.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="广告id",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@GetMapping("/ad/{id}")
	public RestResponse<Object> findById(@PathVariable Integer id) {
		RestResponse<Object> page = adService.findById(id);
		return page;
	}
	/**
	 * 分页查询 广告
	 * @author 
	 * @return
	 * @throws Exception
	 * 
	 */
	@Auth 
	@ApiOperation(value = "分页条件查找广告",notes="分页条件查找广告", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@GetMapping("/ad/pagelist")
	public RestResponse<Object> pagebanklist(HttpServletRequest request) throws Exception{
		RestResponse<Object> page = adService.findPage(new PageInfo(request.getParameterMap()));
		return page;
	}
	
}
