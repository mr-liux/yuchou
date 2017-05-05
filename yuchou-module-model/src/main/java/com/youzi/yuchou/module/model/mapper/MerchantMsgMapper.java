package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MerchantMsg;

public interface MerchantMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantMsg record);

    int insertSelective(MerchantMsg record);

    MerchantMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantMsg record);

    int updateByPrimaryKeyWithBLOBs(MerchantMsg record);

    int updateByPrimaryKey(MerchantMsg record);
}