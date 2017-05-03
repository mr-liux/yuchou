package com.youzi.yuchou.module.model.model;

import java.math.BigDecimal;

public class MemberFunds {
    private Integer uid;

    private BigDecimal balance;

    private BigDecimal freeze;

    private BigDecimal discount;

    private BigDecimal reserve1;

    private BigDecimal reserve2;

    private BigDecimal reserve3;

    private BigDecimal reserve4;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getReserve1() {
        return reserve1;
    }

    public void setReserve1(BigDecimal reserve1) {
        this.reserve1 = reserve1;
    }

    public BigDecimal getReserve2() {
        return reserve2;
    }

    public void setReserve2(BigDecimal reserve2) {
        this.reserve2 = reserve2;
    }

    public BigDecimal getReserve3() {
        return reserve3;
    }

    public void setReserve3(BigDecimal reserve3) {
        this.reserve3 = reserve3;
    }

    public BigDecimal getReserve4() {
        return reserve4;
    }

    public void setReserve4(BigDecimal reserve4) {
        this.reserve4 = reserve4;
    }
}