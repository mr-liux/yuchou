package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderSaler;

public interface OrderSalerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSaler record);

    int insertSelective(OrderSaler record);

    OrderSaler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSaler record);

    int updateByPrimaryKey(OrderSaler record);
}