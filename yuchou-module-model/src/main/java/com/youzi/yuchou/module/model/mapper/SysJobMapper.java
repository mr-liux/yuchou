package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysJob;

public interface SysJobMapper {
    int deleteByPrimaryKey(Integer jobKy);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    SysJob selectByPrimaryKey(Integer jobKy);

    int updateByPrimaryKeySelective(SysJob record);

    int updateByPrimaryKey(SysJob record);
}