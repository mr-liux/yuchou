package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberValidation;

public interface MemberValidationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberValidation record);

    int insertSelective(MemberValidation record);

    MemberValidation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberValidation record);

    int updateByPrimaryKey(MemberValidation record);
}