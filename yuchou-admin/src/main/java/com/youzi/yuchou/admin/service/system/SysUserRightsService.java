package com.youzi.yuchou.admin.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.common.login.service.intf.TokenRightServiceIntf;
import com.youzi.yuchou.admin.repository.system.SysUserRightsRepository;
import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.admin.web.system.domain.response.TreeEntityResponse;
import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.module.model.mapper.SysMenuMapper;
import com.youzi.yuchou.module.model.mapper.SysUserMenuLogMapper;
import com.youzi.yuchou.module.model.mapper.SysUserMenuMapper;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.model.model.SysUserMenu;
import com.youzi.yuchou.module.model.model.SysUserMenuLog;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.response.menu.SysUserMenuResponse;
import com.youzi.yuchou.module.mvc.utils.CommonUtils;

@Service
public class SysUserRightsService  extends AdminBaseService implements TokenRightServiceIntf {
	@Autowired
	private SysUserMenuMapper  userMenuMapper;
	@Autowired
	private SysMenuMapper  menuMapper;
	@Autowired
	private SysUserMenuLogMapper sysUserMenuLogMapper;
	@Autowired
	private SysUserRightsRepository  sysUserRightsRepository;
	
	public boolean add(SysUserMenu users) {
		if(userMenuMapper.insert(users)>0){
			return true;
		}
		return false;
	}

	@Transactional
	public boolean delete(Integer id) {
		if(userMenuMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	@Transactional
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
	 * @param userKy 权限对应的用户
	 * @param menuIds 权限
	 * @param isUserKy 当前操作者
	 */
	@Transactional
	public void update(Integer userKy, Integer[] menuIds ,Integer isUserKy) {
		sysUserRightsRepository.deleteByUserKey(userKy); //删除当前用户的权限，清除缓存
		if(menuIds!=null&&menuIds.length>0){
			List<SysUserMenu> menus=new ArrayList<SysUserMenu>();
			
			menuIds = CommonUtils.toArrayInt(menuIds); //去除重复的数据
			String menuKyStr = "";
			for (int menuId : menuIds) {
				SysUserMenu menu=new SysUserMenu(userKy,menuId);
				menus.add(menu);
				menuKyStr+=menuId+"/";
			}
			sysUserRightsRepository.insertUserMenu(menus); //添加当前用户“新的”的权限
			//分权限的日志
			SysUserMenuLog menuLog = new SysUserMenuLog();
			menuLog.setUserKy(userKy);
			menuLog.setMenuKyStr(menuKyStr);
			menuLog.setIsUserKy(isUserKy);
			menuLog.setStatus(1);
			menuLog.setAddTime(CommonUtils.getDataTime());
			sysUserMenuLogMapper.insert(menuLog); //添加权限日志
		}
	}

	/**
	 * 获取权限封装成json返回，已key=htmlUrl，vaule=SysUserMenuResponse.java
	 * @author 背包
	 * @param userKy
	 * @return
	 */
	public RestResponse<Object> getMyMenu(Integer userKy) {
		StringBuffer buffer = new StringBuffer();
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysMenu> list = sysUserRightsRepository.queryMyMenu(userKy);
//		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> listArr = new ArrayList<Object>();
		if(list.size()>0){
			for (SysMenu m : list) {
				SysUserMenuResponse menuResponse = new SysUserMenuResponse();
				menuResponse.setHtmlUrlKey(m.getHtmlUrl());
				menuResponse.setSysMenu(m);
				listArr.add(menuResponse);
			}
			
			page.setCode(0);
			page.setSuccess(true);
			page.setData(listArr);
			page.setMessage("用户获取权限成功");
			logger.info(userKy+":用户获取权限成功");
			
		}else{
			page.setCode(ExceptionStaticEnum.USER_MENU_NULL.getCode());
			page.setSuccess(false);
			page.setData(listArr);
			page.setMessage(ExceptionStaticEnum.USER_MENU_NULL.getMessage());
			logger.info(userKy+":此用户没有任何权限");
		}
		return page;
	}
	/**
	 * 获取我的菜单
	 * @param uid
	 * @return
	 */

	public List<SysMenu> queryMyMenu(Integer userKy) {
		return  sysUserRightsRepository.queryMyMenu(userKy);
	}

}
