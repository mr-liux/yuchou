package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsSpecDetailPrice implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer gid;

    private Integer goodsSpecid;

    private String splitJointId;

    private BigDecimal price;

    private Integer stockBalance;

    private Integer stockCount;

    private String code;

    private String picUrl;

    private Date addTime;

    private Integer reserve1;

    private String reserve2;

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

    public Integer getGoodsSpecid() {
        return goodsSpecid;
    }

    public void setGoodsSpecid(Integer goodsSpecid) {
        this.goodsSpecid = goodsSpecid;
    }

    public String getSplitJointId() {
        return splitJointId;
    }

    public void setSplitJointId(String splitJointId) {
        this.splitJointId = splitJointId == null ? null : splitJointId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(Integer stockBalance) {
        this.stockBalance = stockBalance;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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