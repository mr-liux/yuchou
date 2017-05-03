package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysUsers;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer userKy);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer userKy);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}