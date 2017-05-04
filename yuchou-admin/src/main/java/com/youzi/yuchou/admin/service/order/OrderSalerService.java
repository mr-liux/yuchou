
package com.youzi.yuchou.admin.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.repository.OrderSalerRepository;
import com.youzi.yuchou.core.enums.CommonStatusEnum;
import com.youzi.yuchou.module.model.mapper.OrderSalerMapper;
import com.youzi.yuchou.module.model.model.OrderSaler;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.service.BaseService;
import com.youzi.yuchou.module.mvc.utils.CommonUtils;

@Service
@Transactional
public class OrderSalerService extends BaseService {

	@Autowired
	private OrderSalerMapper orderSalerMapper;
	@Autowired
	private OrderSalerRepository orderSalerRepository;
	
	
	/**
	 * 根据
	 * @author 背包
	 * @param bank
	 */
	public void add(OrderSaler saler) {
		saler.setOrderId(saler.getOrderId());
		saler.setName(saler.getName());
		saler.setUid(0);
		saler.setParentUid(0);
		saler.setLevel(1);
		saler.setCommission(CommonUtils.bigDecimal(0.00));
		saler.setStatus(CommonStatusEnum.WQS);
		saler.setReserve1(null);	
		boolean result = orderSalerRepository.insert(saler);
		if(!result)
			saler=null;
	}
	@CacheEvict(value = "findByIdOrderSaler", key = "#orderSaler.id")
	public void update(OrderSaler orderSaler) {
		//
	}
	
	/**
	 * 根据主键查询
	 * @author 背包
	 * @param bank
	 */
	@Cacheable(value = "findByIdOrderSaler_1", key = "#id", unless = "#result == null")
	public RestResponse<Object> findById(Integer id) {
		RestResponse<Object> page = new RestResponse<Object>();
		OrderSaler orderSaler = orderSalerMapper.selectByPrimaryKey(id);
		page.setCode(0);
		page.setData(orderSaler); 
		return page;
	}
	@Cacheable(value = "findByIdOrderSaler", key = "#id", unless = "#result == null")
	public OrderSaler findById1(Integer id) {
		OrderSaler orderSaler = orderSalerMapper.selectByPrimaryKey(id);
		return orderSaler;
	}
	
}
