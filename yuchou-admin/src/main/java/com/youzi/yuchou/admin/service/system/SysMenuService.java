package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysMenuMapper;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;

@Service
public class SysMenuService extends AdminBaseService   {
	@Autowired
	private SysMenuMapper  menuMapper;
	
	public boolean add(SysMenu menu) {
		if(menuMapper.insert(menu)>0){
			return true;
		}
		return false;
	}
	@CacheEvict(value = "sys_menus", key = "#id")
	public boolean delete(Integer id) {
		if(menuMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}
	@CacheEvict(value = "sys_menus", key = "#menu.userKy")
	public boolean update(SysMenu menu) {
		if(menuMapper.updateByPrimaryKey(menu)>0){
			return true;
		}
		return false;
	}
	@Cacheable(value = "sys_menus", key = "#id")
	public SysMenu findById(Integer id) {
		SysMenu menu= menuMapper.selectByPrimaryKey(id);
		 return menu;
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysMenu> list = null;
		int totalCount = menuMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = menuMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}




}
