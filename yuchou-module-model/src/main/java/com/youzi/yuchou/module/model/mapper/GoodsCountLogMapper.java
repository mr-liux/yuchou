package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCountLog;

public interface GoodsCountLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCountLog record);

    int insertSelective(GoodsCountLog record);

    GoodsCountLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCountLog record);

    int updateByPrimaryKey(GoodsCountLog record);
}