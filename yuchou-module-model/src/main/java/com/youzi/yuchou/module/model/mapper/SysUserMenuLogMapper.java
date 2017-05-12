package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysUserMenuLog;

public interface SysUserMenuLogMapper {

    int insert(SysUserMenuLog record);

    int insertSelective(SysUserMenuLog record);

    SysUserMenuLog selectByPrimaryKey(Integer id);

}