package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ProductCharge;

public interface ProductChargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCharge record);

    int insertSelective(ProductCharge record);

    ProductCharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCharge record);

    int updateByPrimaryKey(ProductCharge record);
}