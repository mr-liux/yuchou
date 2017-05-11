package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer gid;

    private Integer sid;

    private String title;

    private String sellingPoint;

    private String wshrink;

    private String wsquare;

    private BigDecimal price;

    private BigDecimal pricePrimary;

    private BigDecimal priceBuying;

    private Integer itemCatgrade;

    private Integer itemCatid;

    private Date addTime;

    private Date updTime;

    private Date upperTime;

    private Date downTime;

    private Integer type;

    private Integer status;

    private String code;

    private Integer modeType;

    private Integer reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint == null ? null : sellingPoint.trim();
    }

    public String getWshrink() {
        return wshrink;
    }

    public void setWshrink(String wshrink) {
        this.wshrink = wshrink == null ? null : wshrink.trim();
    }

    public String getWsquare() {
        return wsquare;
    }

    public void setWsquare(String wsquare) {
        this.wsquare = wsquare == null ? null : wsquare.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricePrimary() {
        return pricePrimary;
    }

    public void setPricePrimary(BigDecimal pricePrimary) {
        this.pricePrimary = pricePrimary;
    }

    public BigDecimal getPriceBuying() {
        return priceBuying;
    }

    public void setPriceBuying(BigDecimal priceBuying) {
        this.priceBuying = priceBuying;
    }

    public Integer getItemCatgrade() {
        return itemCatgrade;
    }

    public void setItemCatgrade(Integer itemCatgrade) {
        this.itemCatgrade = itemCatgrade;
    }

    public Integer getItemCatid() {
        return itemCatid;
    }

    public void setItemCatid(Integer itemCatid) {
        this.itemCatid = itemCatid;
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

    public Date getUpperTime() {
        return upperTime;
    }

    public void setUpperTime(Date upperTime) {
        this.upperTime = upperTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getModeType() {
        return modeType;
    }

    public void setModeType(Integer modeType) {
        this.modeType = modeType;
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

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5 == null ? null : reserve5.trim();
    }

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }
}