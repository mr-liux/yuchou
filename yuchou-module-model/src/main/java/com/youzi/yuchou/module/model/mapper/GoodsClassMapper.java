package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsClass;

public interface GoodsClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    GoodsClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);
}