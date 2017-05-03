package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsSpecDetail;

public interface GoodsSpecDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecDetail record);

    int insertSelective(GoodsSpecDetail record);

    GoodsSpecDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSpecDetail record);

    int updateByPrimaryKey(GoodsSpecDetail record);
}