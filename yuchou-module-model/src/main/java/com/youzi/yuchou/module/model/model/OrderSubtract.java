package com.youzi.yuchou.module.model.model;

import java.math.BigDecimal;

public class OrderSubtract {
    private Integer id;

    private Integer orderId;

    private Integer goodsActivityId;

    private Integer couponId;

    private BigDecimal couponAmount;

    private Integer reserve1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsActivityId() {
        return goodsActivityId;
    }

    public void setGoodsActivityId(Integer goodsActivityId) {
        this.goodsActivityId = goodsActivityId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }
}