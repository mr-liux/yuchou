package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer uid;

    private String username;

    private String password;

    private String tpassword;

    private Date regDate;

    private String regIp;

    private Integer regFrom;

    private Integer certPhone;

    private Integer certEmail;

    private Integer certIdentity;

    private Integer certlogin;

    private String salt;

    private Integer uidType;

    private String byCodes;

    private Date bindTime;

    private Date vipendTime;

    private Integer status;

    private Integer reserve1;

    private String reserve2;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword == null ? null : tpassword.trim();
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public Integer getRegFrom() {
        return regFrom;
    }

    public void setRegFrom(Integer regFrom) {
        this.regFrom = regFrom;
    }

    public Integer getCertPhone() {
        return certPhone;
    }

    public void setCertPhone(Integer certPhone) {
        this.certPhone = certPhone;
    }

    public Integer getCertEmail() {
        return certEmail;
    }

    public void setCertEmail(Integer certEmail) {
        this.certEmail = certEmail;
    }

    public Integer getCertIdentity() {
        return certIdentity;
    }

    public void setCertIdentity(Integer certIdentity) {
        this.certIdentity = certIdentity;
    }

    public Integer getCertlogin() {
        return certlogin;
    }

    public void setCertlogin(Integer certlogin) {
        this.certlogin = certlogin;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getUidType() {
        return uidType;
    }

    public void setUidType(Integer uidType) {
        this.uidType = uidType;
    }

    public String getByCodes() {
        return byCodes;
    }

    public void setByCodes(String byCodes) {
        this.byCodes = byCodes == null ? null : byCodes.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getVipendTime() {
        return vipendTime;
    }

    public void setVipendTime(Date vipendTime) {
        this.vipendTime = vipendTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}