package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberValidationLog;

public interface MemberValidationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberValidationLog record);

    int insertSelective(MemberValidationLog record);

    MemberValidationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberValidationLog record);

    int updateByPrimaryKey(MemberValidationLog record);
}