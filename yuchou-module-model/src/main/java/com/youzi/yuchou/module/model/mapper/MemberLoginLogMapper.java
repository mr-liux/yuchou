package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberLoginLog;

public interface MemberLoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberLoginLog record);

    int insertSelective(MemberLoginLog record);

    MemberLoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberLoginLog record);

    int updateByPrimaryKey(MemberLoginLog record);
}