package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsSpecDetailPrice;

public interface GoodsSpecDetailPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecDetailPrice record);

    int insertSelective(GoodsSpecDetailPrice record);

    GoodsSpecDetailPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSpecDetailPrice record);

    int updateByPrimaryKey(GoodsSpecDetailPrice record);
}