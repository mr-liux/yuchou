package com.youzi.yuchou.module.model.model;

import java.util.Date;

public class GoodsStockLog {
    private Integer id;

    private Integer sid;

    private Integer type;

    private Integer sz;

    private Integer goodsSpecDetailPriceId;

    private Integer uid;

    private Integer gid;

    private String orderId;

    private Integer amountCount;

    private Integer balanceCount;

    private String remark;

    private Date addTime;

    private Integer reserve1;

    private String reserve2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSz() {
        return sz;
    }

    public void setSz(Integer sz) {
        this.sz = sz;
    }

    public Integer getGoodsSpecDetailPriceId() {
        return goodsSpecDetailPriceId;
    }

    public void setGoodsSpecDetailPriceId(Integer goodsSpecDetailPriceId) {
        this.goodsSpecDetailPriceId = goodsSpecDetailPriceId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getAmountCount() {
        return amountCount;
    }

    public void setAmountCount(Integer amountCount) {
        this.amountCount = amountCount;
    }

    public Integer getBalanceCount() {
        return balanceCount;
    }

    public void setBalanceCount(Integer balanceCount) {
        this.balanceCount = balanceCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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