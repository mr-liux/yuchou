package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsStock;

public interface GoodsStockMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    GoodsStock selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(GoodsStock record);

    int updateByPrimaryKey(GoodsStock record);
}