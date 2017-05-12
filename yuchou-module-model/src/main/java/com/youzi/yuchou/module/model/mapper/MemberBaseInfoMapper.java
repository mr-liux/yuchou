package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberBaseInfo;

public interface MemberBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberBaseInfo record);

    int insertSelective(MemberBaseInfo record);

    MemberBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberBaseInfo record);

    int updateByPrimaryKey(MemberBaseInfo record);
}