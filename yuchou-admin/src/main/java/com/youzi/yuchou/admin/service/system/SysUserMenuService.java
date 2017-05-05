package com.youzi.yuchou.admin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.module.model.mapper.SysUserMenuMapper;
import com.youzi.yuchou.module.model.model.SysUserMenu;
import com.youzi.yuchou.module.mvc.login.service.intf.TokenRightServiceIntf;

@Service
public class SysUserMenuService  implements TokenRightServiceIntf {
	@Autowired
	private SysUserMenuMapper  userMenuMapper;
	
	public boolean add(SysUserMenu users) {
		if(userMenuMapper.insert(users)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(userMenuMapper.deleteByPrimaryKey(id)>0){
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

	public SysUserMenu findById(Integer id) {
		return userMenuMapper.selectByPrimaryKey(id);
	}
	

	@Override
	public List<Integer> queryUserRights(Integer userKy) {
		
		return userMenuMapper.queryByUserKy(userKy);
	}



}
