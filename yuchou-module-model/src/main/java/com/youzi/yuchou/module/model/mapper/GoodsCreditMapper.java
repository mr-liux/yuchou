package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCredit;

public interface GoodsCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCredit record);

    int insertSelective(GoodsCredit record);

    GoodsCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCredit record);

    int updateByPrimaryKey(GoodsCredit record);
}