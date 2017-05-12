package com.youzi.yuchou.module.model.model;

import java.io.Serializable;

public class GoodsCount implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer gid;

    private Integer sid;

    private Integer uid;

    private Integer theBrowseCount;

    private Integer totalBrowseCount;

    private Integer appMessage;

    private Integer timeline;

    private Integer qq;

    private Integer qqWeibo;

    private Integer qqZone;

    private Integer xlWeibo;

    private Integer reserve1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTheBrowseCount() {
        return theBrowseCount;
    }

    public void setTheBrowseCount(Integer theBrowseCount) {
        this.theBrowseCount = theBrowseCount;
    }

    public Integer getTotalBrowseCount() {
        return totalBrowseCount;
    }

    public void setTotalBrowseCount(Integer totalBrowseCount) {
        this.totalBrowseCount = totalBrowseCount;
    }

    public Integer getAppMessage() {
        return appMessage;
    }

    public void setAppMessage(Integer appMessage) {
        this.appMessage = appMessage;
    }

    public Integer getTimeline() {
        return timeline;
    }

    public void setTimeline(Integer timeline) {
        this.timeline = timeline;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public Integer getQqWeibo() {
        return qqWeibo;
    }

    public void setQqWeibo(Integer qqWeibo) {
        this.qqWeibo = qqWeibo;
    }

    public Integer getQqZone() {
        return qqZone;
    }

    public void setQqZone(Integer qqZone) {
        this.qqZone = qqZone;
    }

    public Integer getXlWeibo() {
        return xlWeibo;
    }

    public void setXlWeibo(Integer xlWeibo) {
        this.xlWeibo = xlWeibo;
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }
}