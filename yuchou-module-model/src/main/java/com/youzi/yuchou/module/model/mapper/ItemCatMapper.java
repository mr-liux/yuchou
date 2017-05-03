package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ItemCat;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    ItemCat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);
}