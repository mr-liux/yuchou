package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantShopFreezeLog;

public interface MerchantShopFreezeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantShopFreezeLog record);

    int insertSelective(MerchantShopFreezeLog record);

    MerchantShopFreezeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantShopFreezeLog record);

    int updateByPrimaryKey(MerchantShopFreezeLog record);
}