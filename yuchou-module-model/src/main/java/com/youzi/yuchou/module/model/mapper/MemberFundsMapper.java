package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberFunds;

public interface MemberFundsMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(MemberFunds record);

    int insertSelective(MemberFunds record);

    MemberFunds selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(MemberFunds record);

    int updateByPrimaryKey(MemberFunds record);
}