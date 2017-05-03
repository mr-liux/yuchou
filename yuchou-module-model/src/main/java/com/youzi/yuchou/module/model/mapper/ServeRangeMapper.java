package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ServeRange;

public interface ServeRangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServeRange record);

    int insertSelective(ServeRange record);

    ServeRange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServeRange record);

    int updateByPrimaryKey(ServeRange record);
}