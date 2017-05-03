package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberMsg;

public interface MemberMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberMsg record);

    int insertSelective(MemberMsg record);

    MemberMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberMsg record);

    int updateByPrimaryKeyWithBLOBs(MemberMsg record);

    int updateByPrimaryKey(MemberMsg record);
}