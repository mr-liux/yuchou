package com.youzi.yuchou.admin.web.system.domain.request;

public class UserRightsRequest {
	
	private  Integer userKy ;
	private Integer[] menuIds;

	public Integer getUserKy() {
		return userKy;
	}
	public void setUserKy(Integer userKy) {
		this.userKy = userKy;
	}
	public Integer[] getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(Integer[] menuIds) {
		this.menuIds = menuIds;
	}
	
	
}
