package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.youzi.yuchou.core.enums.CommonStatusEnum;


public class OrderSaler implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer orderId;

    private String name;

    private Integer uid;

    private Integer parentUid;

    private Integer level;

    private BigDecimal commission;
    
    private CommonStatusEnum status;

    private Date addTime;

    private String reserve1;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getParentUid() {
        return parentUid;
    }

    public void setParentUid(Integer parentUid) {
        this.parentUid = parentUid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

   /* public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }*/

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }
}