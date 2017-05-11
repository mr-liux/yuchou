package com.youzi.yuchou.admin.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.common.login.service.intf.TokenRightServiceIntf;
import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.admin.web.system.domain.response.TreeEntityResponse;
import com.youzi.yuchou.module.model.mapper.SysMenuMapper;
import com.youzi.yuchou.module.model.mapper.SysUserMenuMapper;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.model.model.SysUserMenu;

@Service
@Transactional
public class SysUserRightsService  extends AdminBaseService implements TokenRightServiceIntf {
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

	public SysUserMenu findById(Integer id) {
		return userMenuMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 通过用户id查询当前用户所有菜单ID
	 */
	@Override
	public List<Integer> queryUserRights(Integer userKy) {
		
		return userMenuMapper.queryByUserKy(userKy);
	}

	/**
	 * 获取我的权限列表树状菜单
	 * @param userKy
	 * @return
	 */
	public List<TreeEntityResponse> queryMyRightsTreeMenu(Integer userKy){
		List<TreeEntityResponse> entities=new ArrayList<TreeEntityResponse>();
		List<SysMenu> myMenuInfos = menuMapper.getMyMenu(userKy);
		List<SysMenu> infos = menuMapper.getAllMenu(null);
		for (SysMenu m : infos) {
			TreeEntityResponse entity=new TreeEntityResponse();
			entity.setId(m.getMenuKy());
			for (SysMenu menuInfo : myMenuInfos) {
				if(menuInfo.getMenuKy()==m.getMenuKy()){
					entity.setChecked(true);
					break;
				}
			}
			entity.setName(m.getName());
			entity.setpId(m.getPid());
			entity.setIsParent(true);
			entity.setOpen(true);
			entities.add(entity);
		}
		return entities;
	}

	/**
	 * 修改用户权限
	 * @param userKy
	 * @param menuIds
	 */
	public void update(Integer userKy, Integer[] menuIds) {
		userMenuMapper.deleteByUserKey(userKy);
		if(menuIds!=null&&menuIds.length>0){
			List<SysUserMenu> menus=new ArrayList<SysUserMenu>();
			for (int menuId : menuIds) {
				SysUserMenu menu=new SysUserMenu(userKy,menuId);
				menus.add(menu);
			}
			userMenuMapper.insertUserMenu(menus);
		}
	}

	/**
	 * 获取我的菜单
	 * @param uid
	 * @return
	 */
	public List<SysMenu> queryMyMenu(Integer userKy) {
		return  menuMapper.getMyMenu(userKy);
	}

}
