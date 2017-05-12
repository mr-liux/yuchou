package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysUserMenuLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer userKy;

    private String menuKyStr;

    private Integer isUserKy;

    private Integer status;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }

    public String getMenuKyStr() {
        return menuKyStr;
    }

    public void setMenuKyStr(String menuKyStr) {
        this.menuKyStr = menuKyStr == null ? null : menuKyStr.trim();
    }

    public Integer getIsUserKy() {
        return isUserKy;
    }

    public void setIsUserKy(Integer isUserKy) {
        this.isUserKy = isUserKy;
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
}