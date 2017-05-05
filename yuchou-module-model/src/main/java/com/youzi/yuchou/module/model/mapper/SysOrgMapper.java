package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysOrg;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Integer orgKy);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Integer orgKy);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);
}