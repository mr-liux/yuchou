package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class ItemCatSpec implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer itemCatId;

    private String name;

    private Integer status;

    private Date addTime;

    private Integer level;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Integer itemCatId) {
        this.itemCatId = itemCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}