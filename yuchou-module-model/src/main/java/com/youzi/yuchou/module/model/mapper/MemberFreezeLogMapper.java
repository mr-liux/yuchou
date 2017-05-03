package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberFreezeLog;

public interface MemberFreezeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberFreezeLog record);

    int insertSelective(MemberFreezeLog record);

    MemberFreezeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberFreezeLog record);

    int updateByPrimaryKey(MemberFreezeLog record);
}