package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderGoodsFlow;

public interface OrderGoodsFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoodsFlow record);

    int insertSelective(OrderGoodsFlow record);

    OrderGoodsFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGoodsFlow record);

    int updateByPrimaryKey(OrderGoodsFlow record);
}