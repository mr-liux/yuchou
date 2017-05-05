package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MessageEmailLog;

public interface MessageEmailLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageEmailLog record);

    int insertSelective(MessageEmailLog record);

    MessageEmailLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageEmailLog record);

    int updateByPrimaryKeyWithBLOBs(MessageEmailLog record);

    int updateByPrimaryKey(MessageEmailLog record);
}