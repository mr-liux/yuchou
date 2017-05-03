package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderSubtract;

public interface OrderSubtractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSubtract record);

    int insertSelective(OrderSubtract record);

    OrderSubtract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSubtract record);

    int updateByPrimaryKey(OrderSubtract record);
}