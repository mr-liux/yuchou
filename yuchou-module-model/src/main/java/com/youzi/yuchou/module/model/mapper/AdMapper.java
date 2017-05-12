package com.youzi.yuchou.module.model.mapper;

import java.util.List;
import java.util.Map;

import com.youzi.yuchou.module.model.model.Ad;

public interface AdMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    List<Ad> query(Map<String, Object> conditionMap);
    
    int count(Map<String, Object> keyWord);
}