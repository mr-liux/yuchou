package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer menuKy;

    private Integer pid;
    
    private String htmlUrl;
    
    private String url;

    private String name;

    private String image;

    private String request;

    private Integer attribute;

    private String remark;

    private Integer level;

    private Integer sort;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private Boolean parent;
    
    public Boolean getParent() {
 		return parent==null?false:parent;
 	}

 	public void setParent(Boolean parent) {
 		this.parent = parent;
 	}
    public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public Integer getMenuKy() {
        return menuKy;
    }

    public void setMenuKy(Integer menuKy) {
        this.menuKy = menuKy;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}