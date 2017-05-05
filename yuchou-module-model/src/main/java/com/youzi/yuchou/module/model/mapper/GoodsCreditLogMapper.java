package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCreditLog;

public interface GoodsCreditLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCreditLog record);

    int insertSelective(GoodsCreditLog record);

    GoodsCreditLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCreditLog record);

    int updateByPrimaryKey(GoodsCreditLog record);
}