package com.youzi.yuchou.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youzi.yuchou.module.model.mapper.TbUserMapper;
import com.youzi.yuchou.module.model.model.TbUser;
import com.youzi.yuchou.module.mvc.form.PageSearchForm;

@Service
@Transactional
public class UserService {

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 新增数据
	 * 
	 * @param user
	 */
	public void add(TbUser user) {
		userMapper.insertSelective(user);
	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	@CacheEvict(value = "user", key = "#id")
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改数据
	 * 
	 * @param id
	 */
	@CacheEvict(value = "user", key = "#user.id")
	public void update(TbUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value = "user", key = "#id")
	public TbUser findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页查询示例一
	 * 
	 * @param searchForm
	 * @return
	 */
	public PageInfo<TbUser> findAll(PageSearchForm searchForm) {
		PageHelper.startPage(searchForm);
		List<TbUser> list = userMapper.findAll();
		return new PageInfo<TbUser>(list);
	}

	/**
	 * 分页查询示例二
	 * 
	 * @param searchForm
	 * @return
	 */
	public PageInfo<TbUser> findAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TbUser> list = userMapper.findAll();
		return new PageInfo<TbUser>(list);
	}

}
