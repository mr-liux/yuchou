package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class MemberValidationLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer pid;

    private Integer uid;

    private Integer type;

    private Integer sendType;

    private String phone;

    private String email;

    private String code;

    private String emailCode;

    private String content;

    private String fromIp;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode == null ? null : emailCode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}