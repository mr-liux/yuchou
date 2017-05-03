package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.Content;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer conId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer conId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
}