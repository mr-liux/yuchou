package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCount;

public interface GoodsCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCount record);

    int insertSelective(GoodsCount record);

    GoodsCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCount record);

    int updateByPrimaryKey(GoodsCount record);
}