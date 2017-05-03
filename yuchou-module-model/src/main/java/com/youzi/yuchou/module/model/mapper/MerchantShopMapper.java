package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantShop;

public interface MerchantShopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(MerchantShop record);

    int insertSelective(MerchantShop record);

    MerchantShop selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(MerchantShop record);

    int updateByPrimaryKeyWithBLOBs(MerchantShop record);

    int updateByPrimaryKey(MerchantShop record);
}