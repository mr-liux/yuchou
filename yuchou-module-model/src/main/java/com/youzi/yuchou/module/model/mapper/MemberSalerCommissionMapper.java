package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.MemberSalerCommission;

public interface MemberSalerCommissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberSalerCommission record);

    int insertSelective(MemberSalerCommission record);

    MemberSalerCommission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberSalerCommission record);

    int updateByPrimaryKey(MemberSalerCommission record);
}