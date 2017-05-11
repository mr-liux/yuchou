package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品服务范围表
 * @author 背包  作者QQ：763542022
 * @date 创建时间：2017年5月3日 下午12:29:06
 */
public class ServeRange implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String remark;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private Integer userKy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }
}