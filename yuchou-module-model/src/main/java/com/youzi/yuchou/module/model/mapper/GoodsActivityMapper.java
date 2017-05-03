package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsActivity;

public interface GoodsActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsActivity record);

    int insertSelective(GoodsActivity record);

    GoodsActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsActivity record);

    int updateByPrimaryKey(GoodsActivity record);
}