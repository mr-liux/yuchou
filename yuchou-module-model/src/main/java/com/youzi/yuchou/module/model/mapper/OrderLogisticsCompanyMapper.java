package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.OrderLogisticsCompany;

public interface OrderLogisticsCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderLogisticsCompany record);

    int insertSelective(OrderLogisticsCompany record);

    OrderLogisticsCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderLogisticsCompany record);

    int updateByPrimaryKey(OrderLogisticsCompany record);
}