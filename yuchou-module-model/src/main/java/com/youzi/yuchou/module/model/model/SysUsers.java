package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysUsers implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userKy;

    private String userId;

    private String password;

    private String name;

    private Integer companyKy;
    
    private String companyName;

    private Integer orgKy;
    
    private String orgName;

    private Integer jobKy;
    
    private String jobName;

    private String mobilePhone;

    private String phone;

    private String email;

    private String serviceNum;

    private Integer manageFlag;

    private Integer manageParents;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private String lastLoginIp;

    private Integer lastLoginNum;

    private Integer reserve1;

    private String reserve2;

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCompanyKy() {
        return companyKy;
    }

    public void setCompanyKy(Integer companyKy) {
        this.companyKy = companyKy;
    }

    public Integer getOrgKy() {
        return orgKy;
    }

    public void setOrgKy(Integer orgKy) {
        this.orgKy = orgKy;
    }

    public Integer getJobKy() {
        return jobKy;
    }

    public void setJobKy(Integer jobKy) {
        this.jobKy = jobKy;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum == null ? null : serviceNum.trim();
    }

    public Integer getManageFlag() {
        return manageFlag;
    }

    public void setManageFlag(Integer manageFlag) {
        this.manageFlag = manageFlag;
    }

    public Integer getManageParents() {
        return manageParents;
    }

    public void setManageParents(Integer manageParents) {
        this.manageParents = manageParents;
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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Integer getLastLoginNum() {
        return lastLoginNum;
    }

    public void setLastLoginNum(Integer lastLoginNum) {
        this.lastLoginNum = lastLoginNum;
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

	public String getCompanyName() {
		return companyName==null?"":companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrgName() {
		return orgName==null?"":orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getJobName() {
		return jobName==null?"":jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
    
    
}