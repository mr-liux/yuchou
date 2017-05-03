package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysUserMenu;

public interface SysUserMenuMapper {
    int deleteByPrimaryKey(Integer grantKy);

    int insert(SysUserMenu record);

    int insertSelective(SysUserMenu record);

    SysUserMenu selectByPrimaryKey(Integer grantKy);

    int updateByPrimaryKeySelective(SysUserMenu record);

    int updateByPrimaryKey(SysUserMenu record);
}