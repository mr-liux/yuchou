package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysJobMapper;
import com.youzi.yuchou.module.model.model.SysJob;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysJobService extends AdminBaseService   {
	@Autowired
	private SysJobMapper  jobMapper;
	
	public boolean add(SysJob job) {
		if(jobMapper.insert(job)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(jobMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysJob job) {
		if(jobMapper.updateByPrimaryKey(job)>0){
			return true;
		}
		return false;
	}

	public SysJob findById(Integer id) {
		SysJob job= jobMapper.selectByPrimaryKey(id);
		 return job;
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysJob> list = null;
		int totalCount = jobMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = jobMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}




}
