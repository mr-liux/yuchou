package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberIntegralLog;

public interface MemberIntegralLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberIntegralLog record);

    int insertSelective(MemberIntegralLog record);

    MemberIntegralLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberIntegralLog record);

    int updateByPrimaryKey(MemberIntegralLog record);
}