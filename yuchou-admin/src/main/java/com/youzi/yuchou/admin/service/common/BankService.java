
package com.youzi.yuchou.admin.service.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.repository.BankRepository;
import com.youzi.yuchou.module.model.condition.CommonKeyWordCondition;
import com.youzi.yuchou.module.model.mapper.BankMapper;
import com.youzi.yuchou.module.model.model.Bank;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
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
	@Autowired
	private BankRepository bankRepository;
	
	/**
	 * 添加
	 * @author 背包
	 * @param bank
	 */
	public boolean add(Bank bank) {
		return bankRepository.insert(bank);
	}
	/**
	 * 修改
	 * @author 背包
	 * @param bank
	 */
	public boolean update(Bank bank) {
		return bankRepository.updateByPrimaryKey(bank);
		
	}
	/**
	 * 删除
	 * @author 背包
	 * @param bank
	 */
	public boolean delete(Integer id) {
		return bankRepository.deleteByPrimaryKey(id);
	}
	/**
	 * 根据主键查询
	 * @author 背包
	 * @param bank
	 */
	public RestResponse<Object> findById(Integer id) {
		RestResponse<Object> page = new RestResponse<Object>();
		Bank bank = bankRepository.selectByPrimaryKey(id);
		page.setCode(0);
		page.setData(bank);
		return page;
	}
	/**
	 * 分页查询
	 * @author 背包
	 */
	public RestResponse<Object> findPage(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<Bank> list = null;
		int totalCount = bankMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = bankMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}
	/**
	 * 查询全部
	 * @author 背包
	 */
	public RestResponse<Object> querylistAll(String type) {
		RestResponse<Object> page = new RestResponse<Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(type!=null && type!=""){
			conditionMap.put("type", type);
		}
		List<Bank> list = bankMapper.querylistAll(conditionMap);
		page.setSuccess(true);
		page.setData(list);
		return page;
	}
	
	
}
