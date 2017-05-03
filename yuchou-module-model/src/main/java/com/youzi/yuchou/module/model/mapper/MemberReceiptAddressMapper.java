package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberReceiptAddress;

public interface MemberReceiptAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberReceiptAddress record);

    int insertSelective(MemberReceiptAddress record);

    MemberReceiptAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberReceiptAddress record);

    int updateByPrimaryKey(MemberReceiptAddress record);
}