package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberBank;

public interface MemberBankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberBank record);

    int insertSelective(MemberBank record);

    MemberBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberBank record);

    int updateByPrimaryKey(MemberBank record);
}