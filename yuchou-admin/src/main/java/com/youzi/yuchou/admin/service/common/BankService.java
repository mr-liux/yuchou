
package com.youzi.yuchou.admin.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.module.model.mapper.BankMapper;
import com.youzi.yuchou.module.model.model.Bank;
import com.youzi.yuchou.module.mvc.service.BaseService;

/**
 * 银行卡字典
 * @author 背包  作者QQ：763542022
 * @date 创建时间：2017年4月26日 下午4:03:34
 */
@Service
@Transactional
public class BankService extends BaseService {

	@Autowired
	private BankMapper bankMapper;
	
	/**
	 * 添加
	 * @author 背包
	 * @param bank
	 */
	public void add(Bank bank) {
		bankMapper.insertSelective(bank);
	}
	
}
