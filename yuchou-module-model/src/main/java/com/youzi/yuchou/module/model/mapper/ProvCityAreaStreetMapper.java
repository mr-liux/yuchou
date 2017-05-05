package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;

import java.util.List;

public interface ProvCityAreaStreetMapper {

    int insert(ProvCityAreaStreet record);

    int insertSelective(ProvCityAreaStreet record);

    ProvCityAreaStreet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProvCityAreaStreet record);

    int updateByPrimaryKey(ProvCityAreaStreet record);

    /**
     * 根据级别查询集合
     * @param level
     * @return
     */
    List<ProvCityAreaStreet> getParamsList(Integer level);
    /**
     * 根据code编号作为parentCode父编号的条件查询集合
     * @param code
     * @return
     */
    List<ProvCityAreaStreet> getParentCodeList(Integer code);


}