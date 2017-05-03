package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer adId;

    private Integer adLocatId;

    private String title;

    private String description;

    private String color;

    private String pic;

    private String url;

    private Integer sort;

    private Integer userKy;

    private Integer isUserKy;

    private Integer updUserKy;

    private Integer status;

    private Date addTime;

    private Date updTime;

    private Date releaseTime;

    private String reserve1;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getAdLocatId() {
        return adLocatId;
    }

    public void setAdLocatId(Integer adLocatId) {
        this.adLocatId = adLocatId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }

    public Integer getIsUserKy() {
        return isUserKy;
    }

    public void setIsUserKy(Integer isUserKy) {
        this.isUserKy = isUserKy;
    }

    public Integer getUpdUserKy() {
        return updUserKy;
    }

    public void setUpdUserKy(Integer updUserKy) {
        this.updUserKy = updUserKy;
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }
}