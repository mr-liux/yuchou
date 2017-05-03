package com.youzi.yuchou.module.model.model;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsActivity {
    private Integer id;

    private Integer gid;

    private BigDecimal appointPrice;

    private BigDecimal deratePrice;

    private Integer status;

    private Date addTime;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public BigDecimal getAppointPrice() {
        return appointPrice;
    }

    public void setAppointPrice(BigDecimal appointPrice) {
        this.appointPrice = appointPrice;
    }

    public BigDecimal getDeratePrice() {
        return deratePrice;
    }

    public void setDeratePrice(BigDecimal deratePrice) {
        this.deratePrice = deratePrice;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}