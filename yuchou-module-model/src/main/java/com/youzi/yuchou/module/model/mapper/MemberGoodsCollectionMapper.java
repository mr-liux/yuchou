package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberGoodsCollection;

public interface MemberGoodsCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberGoodsCollection record);

    int insertSelective(MemberGoodsCollection record);

    MemberGoodsCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberGoodsCollection record);

    int updateByPrimaryKey(MemberGoodsCollection record);
}