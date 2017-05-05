package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.CompanyFundsLog;

public interface CompanyFundsLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyFundsLog record);

    int insertSelective(CompanyFundsLog record);

    CompanyFundsLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyFundsLog record);

    int updateByPrimaryKey(CompanyFundsLog record);
}