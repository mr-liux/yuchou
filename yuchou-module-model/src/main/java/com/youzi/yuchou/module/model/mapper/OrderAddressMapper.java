package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderAddress;

public interface OrderAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderAddress record);

    int insertSelective(OrderAddress record);

    OrderAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderAddress record);

    int updateByPrimaryKey(OrderAddress record);
}