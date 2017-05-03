package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsStockLog;

public interface GoodsStockLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsStockLog record);

    int insertSelective(GoodsStockLog record);

    GoodsStockLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsStockLog record);

    int updateByPrimaryKey(GoodsStockLog record);
}