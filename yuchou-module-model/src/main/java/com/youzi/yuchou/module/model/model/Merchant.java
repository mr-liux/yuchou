package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer mid;

    private Integer uid;

    private String musername;

    private String mpassword;

    private Integer aid;

    private Integer pid;

    private String mobilePhone;

    private String email;

    private String mreName;

    private String mreUrl;

    private String phone;

    private Integer type;

    private String enterpriseUrl;

    private String enterpriseName;

    private String enterpriseCcode;

    private String enterpriseRegnum;

    private String enterpriseNumber;

    private Date enterpriseDate;

    private String enterpriseDateType;

    private String enterpriseRealName;

    private Integer provId;

    private Integer cityId;

    private Integer areaId;

    private Integer streetId;

    private String detailAddress;

    private String fullAddress;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private Integer mtype;

    private Integer reserve1;

    private String reserve2;

    private String description;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername == null ? null : musername.trim();
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword == null ? null : mpassword.trim();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMreName() {
        return mreName;
    }

    public void setMreName(String mreName) {
        this.mreName = mreName == null ? null : mreName.trim();
    }

    public String getMreUrl() {
        return mreUrl;
    }

    public void setMreUrl(String mreUrl) {
        this.mreUrl = mreUrl == null ? null : mreUrl.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEnterpriseUrl() {
        return enterpriseUrl;
    }

    public void setEnterpriseUrl(String enterpriseUrl) {
        this.enterpriseUrl = enterpriseUrl == null ? null : enterpriseUrl.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseCcode() {
        return enterpriseCcode;
    }

    public void setEnterpriseCcode(String enterpriseCcode) {
        this.enterpriseCcode = enterpriseCcode == null ? null : enterpriseCcode.trim();
    }

    public String getEnterpriseRegnum() {
        return enterpriseRegnum;
    }

    public void setEnterpriseRegnum(String enterpriseRegnum) {
        this.enterpriseRegnum = enterpriseRegnum == null ? null : enterpriseRegnum.trim();
    }

    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber == null ? null : enterpriseNumber.trim();
    }

    public Date getEnterpriseDate() {
        return enterpriseDate;
    }

    public void setEnterpriseDate(Date enterpriseDate) {
        this.enterpriseDate = enterpriseDate;
    }

    public String getEnterpriseDateType() {
        return enterpriseDateType;
    }

    public void setEnterpriseDateType(String enterpriseDateType) {
        this.enterpriseDateType = enterpriseDateType == null ? null : enterpriseDateType.trim();
    }

    public String getEnterpriseRealName() {
        return enterpriseRealName;
    }

    public void setEnterpriseRealName(String enterpriseRealName) {
        this.enterpriseRealName = enterpriseRealName == null ? null : enterpriseRealName.trim();
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress == null ? null : fullAddress.trim();
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

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}