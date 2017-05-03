package com.youzi.yuchou.admin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.module.model.mapper.OrderSalerMapper;
import com.youzi.yuchou.module.model.model.OrderSaler;
import com.youzi.yuchou.module.mvc.utils.CommonUtils;

@Service
public class OrderSalerRepository {
	
	@Autowired
	private OrderSalerMapper orderSalerMapper;
	
	/**
	 * 添加
	 * @author 背包
	 * @param bank
	 */
	public boolean insert(OrderSaler orderSaler) {
		orderSaler.setAddTime(CommonUtils.getDataTime());
		int result = orderSalerMapper.insert(orderSaler);
		return (result == 1);
	}
	
}