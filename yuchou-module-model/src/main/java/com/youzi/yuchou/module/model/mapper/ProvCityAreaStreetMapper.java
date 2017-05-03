package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;

public interface ProvCityAreaStreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProvCityAreaStreet record);

    int insertSelective(ProvCityAreaStreet record);

    ProvCityAreaStreet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProvCityAreaStreet record);

    int updateByPrimaryKey(ProvCityAreaStreet record);
}