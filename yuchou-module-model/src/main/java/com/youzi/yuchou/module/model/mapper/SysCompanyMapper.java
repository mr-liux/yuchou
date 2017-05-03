package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.SysCompany;

public interface SysCompanyMapper {
    int deleteByPrimaryKey(Integer companyKy);

    int insert(SysCompany record);

    int insertSelective(SysCompany record);

    SysCompany selectByPrimaryKey(Integer companyKy);

    int updateByPrimaryKeySelective(SysCompany record);

    int updateByPrimaryKeyWithBLOBs(SysCompany record);

    int updateByPrimaryKey(SysCompany record);
}