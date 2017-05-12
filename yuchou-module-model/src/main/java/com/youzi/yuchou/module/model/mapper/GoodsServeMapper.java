package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsServe;

public interface GoodsServeMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(GoodsServe record);

    int insertSelective(GoodsServe record);

    GoodsServe selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(GoodsServe record);

    int updateByPrimaryKey(GoodsServe record);
}