package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysOrgMapper;
import com.youzi.yuchou.module.model.model.SysOrg;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysOrgService  extends AdminBaseService  {
	@Autowired
	private SysOrgMapper  orgMapper;
	
	public boolean add(SysOrg org) {
		if(orgMapper.insert(org)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(orgMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysOrg org) {
		if(orgMapper.updateByPrimaryKey(org)>0){
			return true;
		}
		return false;
	}

	public SysOrg findById(Integer id) {
		SysOrg org= orgMapper.selectByPrimaryKey(id);
		 return org;
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysOrg> list = null;
		int totalCount = orgMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = orgMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}




}
