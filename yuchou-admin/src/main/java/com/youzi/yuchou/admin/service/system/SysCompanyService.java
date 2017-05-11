package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysCompanyMapper;
import com.youzi.yuchou.module.model.model.SysCompany;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysCompanyService extends AdminBaseService  {
	@Autowired
	private SysCompanyMapper  companyMapper;
	
	public boolean add(SysCompany company) {
		if(companyMapper.insert(company)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(companyMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysCompany company) {
		if(companyMapper.updateByPrimaryKey(company)>0){
			return true;
		}
		return false;
	}

	public SysCompany findById(Integer id) {
		return companyMapper.selectByPrimaryKey(id);
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysCompany> list = null;
		int totalCount = companyMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = companyMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}




}
