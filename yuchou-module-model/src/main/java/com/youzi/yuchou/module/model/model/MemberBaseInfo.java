package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class MemberBaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer uid;

    private String nickName;

    private String realName;

    private Integer sex;

    private String mobilePhone;

    private String email;

    private String idcards;

    private String idaddress;

    private Integer idareaId;

    private Date idcardsData;

    private Date addTime;

    private Date updTime;

    private Integer reserve1;

    private String reserve2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public String getIdcards() {
        return idcards;
    }

    public void setIdcards(String idcards) {
        this.idcards = idcards == null ? null : idcards.trim();
    }

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress == null ? null : idaddress.trim();
    }

    public Integer getIdareaId() {
        return idareaId;
    }

    public void setIdareaId(Integer idareaId) {
        this.idareaId = idareaId;
    }

    public Date getIdcardsData() {
        return idcardsData;
    }

    public void setIdcardsData(Date idcardsData) {
        this.idcardsData = idcardsData;
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