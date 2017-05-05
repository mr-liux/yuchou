package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberIntegral;

public interface MemberIntegralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberIntegral record);

    int insertSelective(MemberIntegral record);

    MemberIntegral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberIntegral record);

    int updateByPrimaryKey(MemberIntegral record);
}