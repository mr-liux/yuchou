package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class GoodsCreditLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer gid;

    private Integer uid;

    private Double desScore;

    private Double priceScore;

    private Double goodsScore;

    private Date addTime;

    private Integer reserve1;

    private Integer reserve2;

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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getDesScore() {
        return desScore;
    }

    public void setDesScore(Double desScore) {
        this.desScore = desScore;
    }

    public Double getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(Double priceScore) {
        this.priceScore = priceScore;
    }

    public Double getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(Double goodsScore) {
        this.goodsScore = goodsScore;
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

    public Integer getReserve2() {
        return reserve2;
    }

    public void setReserve2(Integer reserve2) {
        this.reserve2 = reserve2;
    }
}