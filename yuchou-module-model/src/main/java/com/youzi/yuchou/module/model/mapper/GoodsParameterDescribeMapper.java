package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsParameterDescribe;
import com.youzi.yuchou.module.model.model.GoodsParameterDescribeWithBLOBs;

public interface GoodsParameterDescribeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsParameterDescribeWithBLOBs record);

    int insertSelective(GoodsParameterDescribeWithBLOBs record);

    GoodsParameterDescribeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsParameterDescribeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsParameterDescribeWithBLOBs record);

    int updateByPrimaryKey(GoodsParameterDescribe record);
}