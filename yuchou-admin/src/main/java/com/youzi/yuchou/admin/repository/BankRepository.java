package com.youzi.yuchou.admin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.module.model.mapper.BankMapper;
import com.youzi.yuchou.module.model.model.Bank;

@Service
public class BankRepository {
	@Autowired
	private BankMapper bankMapper;
	
	/**
	 * 添加
	 * @author 背包
	 * @param bank
	 */
	public boolean insert(Bank bank) {
//		bank.setAddTime(new Date() );
		int result = bankMapper.insert(bank);
		return (result == 1);
	}
	/**
	 * 修改
	 * @author 背包
	 * @param bank
	 * @ CacheEvict(value = "user", key = "#bank.id") 是将缓存中的对象为id的数据清除
	 */
	@CacheEvict(value = "bank", key = "#bank.id")
	public boolean updateByPrimaryKey(Bank bank) {
		int result = bankMapper.updateByPrimaryKey(bank);
		return (result == 1);
	}
	/**
	 * 删除
	 * @author 背包
	 * @param bank
	 * @ CacheEvict(value = "bank", key = "#id") 是将缓存中的对象为id的数据清除
	 */
	@CacheEvict(value = "bank", key = "#id")
	public boolean deleteByPrimaryKey(Integer id) {
		int result = bankMapper.deleteByPrimaryKey(id);
		return (result == 1);
	}
	/**
	 * 根据主键查询
	 * @author 背包
	 * @param bank
	 * @ Cacheable(value = "bank", key = "#id", unless = "#result == null") 是将对象为id的数据存入缓存中
	 */
	@Cacheable(value = "bank", key = "#id")
	public Bank selectByPrimaryKey(Integer id) {
		return bankMapper.selectByPrimaryKey(id);
	}
}
