package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemberSalerCommission implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer salerLevel;

    private BigDecimal commission;

    private Integer status;

    private String reserve1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalerLevel() {
        return salerLevel;
    }

    public void setSalerLevel(Integer salerLevel) {
        this.salerLevel = salerLevel;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }
}