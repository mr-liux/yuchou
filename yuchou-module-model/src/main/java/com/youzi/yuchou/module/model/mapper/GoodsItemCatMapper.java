package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsItemCat;

public interface GoodsItemCatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsItemCat record);

    int insertSelective(GoodsItemCat record);

    GoodsItemCat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsItemCat record);

    int updateByPrimaryKey(GoodsItemCat record);
}