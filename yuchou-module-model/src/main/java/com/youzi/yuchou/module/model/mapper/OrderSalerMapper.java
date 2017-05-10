package com.youzi.yuchou.module.model.mapper;

import java.util.List;
import java.util.Map;

import com.youzi.yuchou.module.model.model.OrderSaler;

public interface OrderSalerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSaler record);

    int insertSelective(OrderSaler record);

    OrderSaler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSaler record);

    int updateByPrimaryKey(OrderSaler record);
    
    List<OrderSaler> query(Map<String, Object> conditionMap);
    
    int count(Map<String, Object> keyWord);
}