package com.youzi.yuchou.admin.web.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youzi.yuchou.admin.service.order.OrderSalerService;
import com.youzi.yuchou.core.mapper.JsonMapper;
import com.youzi.yuchou.module.model.model.OrderSaler;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.web.BaseController;

@RestController
public class OrderSalerController extends BaseController {

	@Autowired
	OrderSalerService orderSalerService;
	
	@PostMapping("/orderSaler")
	public RestResponse<OrderSaler> add(@RequestBody OrderSaler saler){
		RestResponse<OrderSaler> page = new RestResponse<OrderSaler>();
		orderSalerService.add(saler);
		page.setCode(0);
		page.setSuccess(true);
		page.setData(saler);
		page.setMessgae("新增成功");
		return buildSuccessed(page);
	}
	
	/*@GetMapping("/OrderSaler/{id}")
	public RestResponse<Object> findById(@PathVariable Integer id) {
		RestResponse<Object> page = orderSalerService.findById(id);
		return page;
	}*/
	
	@GetMapping("/orderSaler/{id}")
	public RestResponse<Object> findById1(@PathVariable Integer id) {
		OrderSaler orderSaler = orderSalerService.findById1(id);
		RestResponse<Object> page=new RestResponse<Object>(); 
		page.setCode(0);
		page.setSuccess(true);
		page.setData(orderSaler);
		return page;
	}
}
