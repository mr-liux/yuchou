package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderRefundLog;

public interface OrderRefundLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderRefundLog record);

    int insertSelective(OrderRefundLog record);

    OrderRefundLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderRefundLog record);

    int updateByPrimaryKey(OrderRefundLog record);
}