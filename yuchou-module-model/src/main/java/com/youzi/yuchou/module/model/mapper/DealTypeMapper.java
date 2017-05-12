package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.DealType;

public interface DealTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DealType record);

    int insertSelective(DealType record);

    DealType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DealType record);

    int updateByPrimaryKey(DealType record);
}