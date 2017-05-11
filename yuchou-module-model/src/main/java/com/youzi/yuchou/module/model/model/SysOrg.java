package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysOrg implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orgKy;

    private String name;

    private Integer pid;
    
    private String pname;

    private Integer operation;

    private Integer manageId;

    private Integer status;

    private Date addTime;

    private Date updTime;

    
    public String getPname() {
		return pname==null?"":pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getOrgKy() {
        return orgKy;
    }

    public void setOrgKy(Integer orgKy) {
        this.orgKy = orgKy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
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