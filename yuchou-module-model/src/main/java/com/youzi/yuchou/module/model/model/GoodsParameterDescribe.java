package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class GoodsParameterDescribe implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer gid;

    private Date addTime;

    private Date updTime;

    private String goodsDescription;

    private String goodsDescriptionMobile;

    private String goodsParameter;

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
    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getGoodsDescriptionMobile() {
        return goodsDescriptionMobile;
    }

    public void setGoodsDescriptionMobile(String goodsDescriptionMobile) {
        this.goodsDescriptionMobile = goodsDescriptionMobile == null ? null : goodsDescriptionMobile.trim();
    }

    public String getGoodsParameter() {
        return goodsParameter;
    }

    public void setGoodsParameter(String goodsParameter) {
        this.goodsParameter = goodsParameter == null ? null : goodsParameter.trim();
    }
}