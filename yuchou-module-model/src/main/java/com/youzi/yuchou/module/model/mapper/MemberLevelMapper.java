package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberLevel;

public interface MemberLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberLevel record);

    int insertSelective(MemberLevel record);

    MemberLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberLevel record);

    int updateByPrimaryKey(MemberLevel record);
}