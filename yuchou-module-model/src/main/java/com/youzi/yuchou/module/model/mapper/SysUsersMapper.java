package com.youzi.yuchou.module.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.youzi.yuchou.module.model.model.SysUsers;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer userKy);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer userKy);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
    
    int count(Map<String,Object> params);
    
    List<SysUsers> query(Map<String,Object> params);
    
    SysUsers queryByUserCode(@Param(value="code")String code);
}