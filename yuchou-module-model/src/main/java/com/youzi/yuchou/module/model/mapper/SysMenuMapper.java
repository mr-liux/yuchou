package com.youzi.yuchou.module.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.youzi.yuchou.module.model.model.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuKy);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuKy);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

	List<SysMenu> getMyMenu(@Param(value="userKy")int  userKy);

	List<SysMenu> getAllMenu(Map<String,Object> params);
	
	int updateByStatus(Integer menuKy);

	List<SysMenu> query(Map<String, Object> paramsMap);

	int count(Map<String, Object> paramsMap);
}