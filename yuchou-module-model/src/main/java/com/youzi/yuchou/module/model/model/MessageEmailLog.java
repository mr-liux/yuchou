package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class MessageEmailLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer uid;

    private Integer type;

    private String email;

    private String title;

    private String code;

    private Integer results;

    private Date addTime;

    private Integer userKy;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getUserKy() {
        return userKy;
    }

    public void setUserKy(Integer userKy) {
        this.userKy = userKy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}