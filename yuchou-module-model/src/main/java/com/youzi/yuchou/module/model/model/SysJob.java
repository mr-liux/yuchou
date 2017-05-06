package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysJob implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer jobKy;

    private String name;

    private Integer pid;

    private Integer orgKy;
    
    private String oname;
    
    private Integer companyKy;
    
    private String cname;

    private Integer manageId;

    private Integer status;

    private Date addTime;

    private Date updTime;

    
    
    public String getOname() {
		return oname==null?"":oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getCname() {
		return cname==null?"":cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCompanyKy() {
		return companyKy;
	}

	public void setCompanyKy(Integer companyKy) {
		this.companyKy = companyKy;
	}

	public Integer getJobKy() {
        return jobKy;
    }

    public void setJobKy(Integer jobKy) {
        this.jobKy = jobKy;
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

    public Integer getOrgKy() {
        return orgKy;
    }

    public void setOrgKy(Integer orgKy) {
        this.orgKy = orgKy;
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