package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantItemCat;

public interface MerchantItemCatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantItemCat record);

    int insertSelective(MerchantItemCat record);

    MerchantItemCat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantItemCat record);

    int updateByPrimaryKey(MerchantItemCat record);
}