package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ItemCatSpec;

public interface ItemCatSpecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemCatSpec record);

    int insertSelective(ItemCatSpec record);

    ItemCatSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemCatSpec record);

    int updateByPrimaryKey(ItemCatSpec record);
}