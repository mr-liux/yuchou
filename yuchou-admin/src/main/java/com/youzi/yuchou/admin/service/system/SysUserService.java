package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.module.model.mapper.SysUsersMapper;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysUserService   {
	@Autowired
	private SysUsersMapper  userMapper;
	
	public boolean add(SysUsers users) {
		if(userMapper.insert(users)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(userMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysUsers users) {
		if(userMapper.updateByPrimaryKey(users)>0){
			return true;
		}
		return false;
	}

	public SysUsers findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysUsers> list = null;
		int totalCount = userMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = userMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}

}
