package com.youzi.yuchou.admin.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.common.login.domain.User;
import com.youzi.yuchou.admin.common.login.service.intf.TokenUserServiceIntf;
import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysUsersMapper;
import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysUserService  extends AdminBaseService  implements TokenUserServiceIntf {
	@Autowired
	private SysUsersMapper  userMapper;
	
	
	public boolean add(SysUsers users) {
		if(userMapper.insert(users)>0){
			return true;
		}
		return false;
	}

	@CacheEvict(value = "sys_users", key = "#id")
	public boolean delete(Integer id) {
		if(userMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@CacheEvict(value = "sys_users", key = "#users.userKy")
	public boolean update(SysUsers users) {
		if(userMapper.updateByPrimaryKey(users)>0){
			return true;
		}
		return false;
	}

	@Cacheable(value = "sys_users", key = "#id")
	public SysUsers findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysUsers> list = new ArrayList<SysUsers>();
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

	@Override
	public User queryUserByCode(String userCode) {
		SysUsers users = userMapper.queryByUserCode(userCode);
		if(users!=null){
			User user = new User();
			user.setUserKy(users.getUserKy());
			user.setUserId(users.getUserId());
			user.setPassword(users.getPassword());
			user.setStatus(users.getStatus());
			return user;
		}
		return null;
	}

	@Override
	public boolean modifyUser(User user) {
		return false;
	}



}
