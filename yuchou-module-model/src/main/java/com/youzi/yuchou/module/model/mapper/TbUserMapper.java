package com.youzi.yuchou.module.model.mapper;

import java.util.List;

import com.youzi.yuchou.module.model.model.TbUser;

public interface TbUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbUser record);

	int insertSelective(TbUser record);

	TbUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbUser record);

	int updateByPrimaryKey(TbUser record);

	List<TbUser> findAll();
}