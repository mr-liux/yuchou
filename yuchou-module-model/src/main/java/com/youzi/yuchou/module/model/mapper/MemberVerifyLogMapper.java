package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberVerifyLog;

public interface MemberVerifyLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberVerifyLog record);

    int insertSelective(MemberVerifyLog record);

    MemberVerifyLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberVerifyLog record);

    int updateByPrimaryKey(MemberVerifyLog record);
}