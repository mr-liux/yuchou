package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberShoppingCart;

public interface MemberShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberShoppingCart record);

    int insertSelective(MemberShoppingCart record);

    MemberShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberShoppingCart record);

    int updateByPrimaryKey(MemberShoppingCart record);
}