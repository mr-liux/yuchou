package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantShopFundsLog;

public interface MerchantShopFundsLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantShopFundsLog record);

    int insertSelective(MerchantShopFundsLog record);

    MerchantShopFundsLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantShopFundsLog record);

    int updateByPrimaryKey(MerchantShopFundsLog record);
}