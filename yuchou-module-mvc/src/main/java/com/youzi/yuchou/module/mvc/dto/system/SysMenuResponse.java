package com.youzi.yuchou.module.mvc.dto.system;


import java.util.Date;

import com.youzi.yuchou.module.mvc.dto.TreeNode;

public class SysMenuResponse extends TreeNode{
	private Integer menuKy;

    
    private String htmlUrl;
    
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
    
	public String getHtmlUrl() {
		return htmlUrl==null?"":htmlUrl;
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

   
    public String getName() {
        return name==null?"":name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image==null?"":image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getRequest() {
        return request==null?"":request;
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
        return remark==null?"":remark;
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
