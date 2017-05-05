package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.Ad;

public interface AdMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}