package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MessagePhoneLog;

public interface MessagePhoneLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessagePhoneLog record);

    int insertSelective(MessagePhoneLog record);

    MessagePhoneLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessagePhoneLog record);

    int updateByPrimaryKey(MessagePhoneLog record);
}