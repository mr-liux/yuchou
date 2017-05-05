package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberFundsLog;

public interface MemberFundsLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberFundsLog record);

    int insertSelective(MemberFundsLog record);

    MemberFundsLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberFundsLog record);

    int updateByPrimaryKey(MemberFundsLog record);
}