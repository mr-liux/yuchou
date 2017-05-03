package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ContentType;

public interface ContentTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentType record);

    int insertSelective(ContentType record);

    ContentType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentType record);

    int updateByPrimaryKey(ContentType record);
}