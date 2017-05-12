package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberVerify;

public interface MemberVerifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberVerify record);

    int insertSelective(MemberVerify record);

    MemberVerify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberVerify record);

    int updateByPrimaryKey(MemberVerify record);
}