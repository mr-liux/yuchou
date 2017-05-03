package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberCodes;

public interface MemberCodesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberCodes record);

    int insertSelective(MemberCodes record);

    MemberCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberCodes record);

    int updateByPrimaryKey(MemberCodes record);
}