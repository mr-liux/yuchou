package com.youzi.yuchou.admin.web.common;

import com.youzi.yuchou.admin.service.common.ProvCityAreaStreetService;
import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Api(value = "API - ProvCityAreaStreetController", description = "后台查询省市4级联动")
@RequestMapping("/admin")
@RestController
public class ProvCityAreaStreetController extends BaseController {

	@Autowired
	ProvCityAreaStreetService provCityAreaStreetService;

	/**
	 * 根据code编号作为parentCode父编号的条件查询集合
	 * @param code
	 * @return
	 */
	@Auth 
	@ApiOperation(value = "后台查询省市-根据code编号作为parentCode父编号的条件查询集合",notes="根据code查询省市的下级信息", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="code",value="数据编号code",required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")
	})
	@GetMapping("/provcitylist/{code}")
	public RestResponse<Object> provcitylist(@PathVariable int code){
		RestResponse<Object> page = new RestResponse<Object>();
		List<ProvCityAreaStreet> list = provCityAreaStreetService.getParentCodeList(code);
		page.setCode(0);
		page.setSuccess(true);
		page.setData(list);
		page.setMessage("成功");
		return buildSuccessed(page);
	}

	/**
	 * 根据级别查询集合
	 * @author 背包
	 * @param level
	 */
	@GetMapping("/provcitylist/paramslist")
	public RestResponse<Object> paramsList(){
		RestResponse<Object> page = new RestResponse<Object>();
		List<ProvCityAreaStreet> list = provCityAreaStreetService.getParamsList(1);
		page.setCode(0);
		page.setSuccess(true);
		page.setData(list);
		page.setMessage("成功");
		return buildSuccessed(page);
	}

}
