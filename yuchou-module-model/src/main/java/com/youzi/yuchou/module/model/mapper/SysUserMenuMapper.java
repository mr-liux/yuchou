package com.youzi.yuchou.module.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.youzi.yuchou.module.model.model.SysUserMenu;

public interface SysUserMenuMapper {
    int deleteByPrimaryKey(Integer grantKy);

    int insert(SysUserMenu record);

    int insertSelective(SysUserMenu record);

    SysUserMenu selectByPrimaryKey(Integer grantKy);

    int updateByPrimaryKeySelective(SysUserMenu record);

    int updateByPrimaryKey(SysUserMenu record);

	List<Integer> queryByUserKy(@Param("userKy")Integer userKy);
	
	int deleteByUserKey(@Param("userKy")Integer userKy);
	
	int insertUserMenu(@Param(value="menus") List<SysUserMenu> menus);

	int updateByStatus(Integer grantKy);
}