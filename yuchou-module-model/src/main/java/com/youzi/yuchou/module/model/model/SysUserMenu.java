package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysUserMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer grantKy;

    private Integer userKy;

    private Integer menuKy;

    private Integer status;

    private Date addTime;

    private Date updTime;

    

	public SysUserMenu() {
		super();
	}

	public SysUserMenu(Integer userKy, Integer menuKy) {
		super();
		this.userKy = userKy;
		this.menuKy = menuKy;
	}

	public Integer getGrantKy() {
        return grantKy;
    }

    public void setGrantKy(Integer grantKy) {
        this.grantKy = grantKy;
    }

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }

    public Integer getMenuKy() {
        return menuKy;
    }

    public void setMenuKy(Integer menuKy) {
        this.menuKy = menuKy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}