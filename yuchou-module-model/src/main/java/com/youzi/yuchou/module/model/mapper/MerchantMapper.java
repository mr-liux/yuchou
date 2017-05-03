package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.Merchant;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKeyWithBLOBs(Merchant record);

    int updateByPrimaryKey(Merchant record);
}