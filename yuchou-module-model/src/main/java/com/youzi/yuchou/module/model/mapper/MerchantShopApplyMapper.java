package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantShopApply;

public interface MerchantShopApplyMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(MerchantShopApply record);

    int insertSelective(MerchantShopApply record);

    MerchantShopApply selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(MerchantShopApply record);

    int updateByPrimaryKey(MerchantShopApply record);
}