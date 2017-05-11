package com.youzi.yuchou.admin.web.order;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzi.yuchou.admin.service.order.OrderSalerService;
import com.youzi.yuchou.module.model.model.OrderSaler;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.web.BaseController;

@Api(value = "API - OrderSalerController", description = "订单销售分销记录")
@RequestMapping("/admin")
@RestController
public class OrderSalerController extends BaseController {

	@Autowired
	OrderSalerService orderSalerService;
	
	@GetMapping("/orderSaler/{id}")
	public RestResponse<Object> findById(@PathVariable Integer id) {
		OrderSaler orderSaler = orderSalerService.findById(id);
		RestResponse<Object> page=new RestResponse<Object>(); 
		page.setCode(0);
		page.setSuccess(true);
		page.setData(orderSaler);
		return page;
	}
	
	/**
	 * 分页查询 订单销售分销记录
	 * @author 
	 * @return
	 * @throws Exception
	 * 
	 */
	@Auth 
	@ApiOperation(value = "分页条件查找订单销售分销记录",notes="分页条件查找订单销售分销记录", httpMethod = "GET", response = RestResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cpage", value="当前页",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pagesize", value="每页显示几条",required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "X-AUTH-TOKEN",value="权限token",required = true, dataType = "Sting", paramType = "header")})
	@GetMapping("/ordersaler/pagelist")
	public RestResponse<Object> pageOrderSaler(HttpServletRequest request) throws Exception{
		RestResponse<Object> page = orderSalerService.findPage(new PageInfo(request.getParameterMap()));
		return page;
	}
}
