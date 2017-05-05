package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantShopFunds;

public interface MerchantShopFundsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantShopFunds record);

    int insertSelective(MerchantShopFunds record);

    MerchantShopFunds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantShopFunds record);

    int updateByPrimaryKey(MerchantShopFunds record);
}