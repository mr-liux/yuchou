package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.AdLocation;

public interface AdLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdLocation record);

    int insertSelective(AdLocation record);

    AdLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdLocation record);

    int updateByPrimaryKey(AdLocation record);
}