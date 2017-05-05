package com.youzi.yuchou.admin.web.system.intf;

import com.youzi.yuchou.module.model.model.SysUsers;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

public interface SysUserServiceIntf {
	
	public boolean add(SysUsers users);
	
	public boolean delete(Integer id);
	
	public boolean update(SysUsers users);
	
	public SysUsers findById(Integer id);
	
	public RestResponse<Object> findAll(PageInfo pageInfo);
	
}
