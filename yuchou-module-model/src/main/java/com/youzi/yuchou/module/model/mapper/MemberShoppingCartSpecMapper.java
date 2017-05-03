package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberShoppingCartSpec;

public interface MemberShoppingCartSpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberShoppingCartSpec record);

    int insertSelective(MemberShoppingCartSpec record);

    MemberShoppingCartSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberShoppingCartSpec record);

    int updateByPrimaryKey(MemberShoppingCartSpec record);
}