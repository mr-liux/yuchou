package com.youzi.yuchou.admin.repository.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.common.login.service.intf.TokenRightServiceIntf;
import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.admin.web.system.domain.response.TreeEntityResponse;
import com.youzi.yuchou.module.model.mapper.SysMenuMapper;
import com.youzi.yuchou.module.model.mapper.SysUserMenuMapper;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.model.model.SysUserMenu;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.response.menu.SysUserMenuResponse;

@Service
public class SysUserRightsRepository {
	@Autowired
	private SysUserMenuMapper  userMenuMapper;
	@Autowired
	private SysMenuMapper  menuMapper;
	
	public boolean add(SysUserMenu users) {
		if(userMenuMapper.insert(users)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(userMenuMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysUserMenu users) {
		if(userMenuMapper.updateByPrimaryKey(users)>0){
			return true;
		}
		return false;
	}
	
	public boolean insertUserMenu(List<SysUserMenu> menus) {
		int result = userMenuMapper.insertUserMenu(menus);
		return (result == 1);
	}
	
	@CacheEvict(value = "sysUserMenu_userKy", key = "#userKy")
	public void deleteByUserKey(Integer userKy) {
		userMenuMapper.deleteByUserKey(userKy);
	}

	public SysUserMenu findById(Integer id) {
		return userMenuMapper.selectByPrimaryKey(id);
	}
	

	/**
	 * 获取我的菜单
	 * @param uid
	 * @return
	 */
	@Cacheable(value = "sysUserMenu_userKy", key = "#userKy")
	public List<SysMenu> queryMyMenu(Integer userKy) {
		return  menuMapper.getMyMenu(userKy);
	}

}
