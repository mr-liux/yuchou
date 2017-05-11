package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class GoodsCommentPic implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer commentId;

    private Integer type;

    private Integer gid;

    private String picPc;

    private String picShrink;

    private String picSquare;

    private Integer sort;

    private Integer status;

    private Date addTime;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getPicPc() {
        return picPc;
    }

    public void setPicPc(String picPc) {
        this.picPc = picPc == null ? null : picPc.trim();
    }

    public String getPicShrink() {
        return picShrink;
    }

    public void setPicShrink(String picShrink) {
        this.picShrink = picShrink == null ? null : picShrink.trim();
    }

    public String getPicSquare() {
        return picSquare;
    }

    public void setPicSquare(String picSquare) {
        this.picSquare = picSquare == null ? null : picSquare.trim();
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}