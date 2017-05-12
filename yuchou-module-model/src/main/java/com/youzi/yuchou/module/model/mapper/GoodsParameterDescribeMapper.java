package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsParameterDescribe;

public interface GoodsParameterDescribeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsParameterDescribe record);

    int insertSelective(GoodsParameterDescribe record);

    GoodsParameterDescribe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsParameterDescribe record);

    int updateByPrimaryKey(GoodsParameterDescribe record);
}