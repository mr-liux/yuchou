package com.youzi.yuchou.module.model.model;

import java.util.Date;

public class Product {
    private Integer pid;

    private String name;

    private Integer appleShop;

    private Integer description;

    private Double rate;

    private Integer deductionsWay;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private Integer userKy;

    private Integer reserve1;

    private String reserve2;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAppleShop() {
        return appleShop;
    }

    public void setAppleShop(Integer appleShop) {
        this.appleShop = appleShop;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getDeductionsWay() {
        return deductionsWay;
    }

    public void setDeductionsWay(Integer deductionsWay) {
        this.deductionsWay = deductionsWay;
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

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
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