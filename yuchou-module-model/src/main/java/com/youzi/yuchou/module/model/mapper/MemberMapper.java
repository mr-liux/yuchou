package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}