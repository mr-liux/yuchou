package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.CompanyFunds;

public interface CompanyFundsMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(CompanyFunds record);

    int insertSelective(CompanyFunds record);

    CompanyFunds selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(CompanyFunds record);

    int updateByPrimaryKey(CompanyFunds record);
}