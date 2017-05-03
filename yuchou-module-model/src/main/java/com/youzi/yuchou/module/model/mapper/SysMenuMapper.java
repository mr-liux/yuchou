package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuKy);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuKy);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}