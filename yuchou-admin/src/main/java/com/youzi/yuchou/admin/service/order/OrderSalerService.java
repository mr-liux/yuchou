
package com.youzi.yuchou.admin.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.repository.OrderSalerRepository;
import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.core.enums.CommonStatusEnum;
import com.youzi.yuchou.module.model.mapper.OrderSalerMapper;
import com.youzi.yuchou.module.model.model.OrderSaler;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
@Transactional
public class OrderSalerService extends AdminBaseService {

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
//		saler.setOrderId(saler.getOrderId());
//		saler.setName(saler.getName());
//		saler.setUid(0);
//		saler.setParentUid(0);
//		saler.setLevel(1);
//		saler.setCommission(CommonUtils.bigDecimal(0.00));
		saler.setStatus(CommonStatusEnum.WQS);
		saler.setReserve1(null);	
		boolean result = orderSalerRepository.insert(saler);
		if(!result)
			saler=null;
	}
	
//	@CacheEvict(value = "findByIdOrderSaler", key = "#orderSaler.id")
	public void update(OrderSaler orderSaler) {
		//
	}
	
	/**
	 * 根据主键查询
	 * @author 背包
	 * @param bank
	 */
	/*@Cacheable(value = "findByIdOrderSaler_1", key = "#id", unless = "#result == null")
	public RestResponse<Object> findById(Integer id) {
		RestResponse<Object> page = new RestResponse<Object>();
		OrderSaler orderSaler = orderSalerMapper.selectByPrimaryKey(id);
		page.setCode(0);
		page.setData(orderSaler); 
		return page;
	}*/
//	@Cacheable(value = "findByIdOrderSaler", key = "#id")
	public OrderSaler findById(Integer id) {
		OrderSaler orderSaler = orderSalerMapper.selectByPrimaryKey(id);
		return orderSaler;
	}
	
	
	public RestResponse<Object> findPage(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<OrderSaler> list = null;
		int totalCount = orderSalerMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = orderSalerMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}
}
