package com.youzi.yuchou.module.model.model;

public class GoodsParameterDescribeWithBLOBs extends GoodsParameterDescribe {
    private String goodsDescription;

    private String goodsDescriptionMobile;

    private String goodsParameter;

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