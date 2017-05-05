package com.youzi.yuchou.admin.web.common;

import com.youzi.yuchou.admin.service.common.ProvCityAreaStreetService;
import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProvCityAreaStreetController extends BaseController {

	@Autowired
	ProvCityAreaStreetService provCityAreaStreetService;

	/**
	 * 根据code编号作为parentCode父编号的条件查询集合
	 * @param code
	 * @return
	 */
	@GetMapping("/provcitylist/{code}")
	public RestResponse<Object> provcitylist(@PathVariable int code){
		RestResponse<Object> page = new RestResponse<Object>();
		List<ProvCityAreaStreet> list = provCityAreaStreetService.getParentCodeList(code);
		page.setCode(0);
		page.setSuccess(true);
		page.setData(list);
		page.setMessgae("成功");
		return buildSuccessed(page);
	}

	/**
	 * 根据级别查询集合
	 * @author 背包
	 * @param level
	 */
	@GetMapping("/paramslist")
	public RestResponse<Object> paramsList(){
		RestResponse<Object> page = new RestResponse<Object>();
		List<ProvCityAreaStreet> list = provCityAreaStreetService.getParamsList(1);
		page.setCode(0);
		page.setSuccess(true);
		page.setData(list);
		page.setMessgae("成功");
		return buildSuccessed(page);
	}

}
