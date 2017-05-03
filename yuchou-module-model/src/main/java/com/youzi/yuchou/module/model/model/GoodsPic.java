package com.youzi.yuchou.module.model.model;

public class GoodsPic {
    private Integer id;

    private Integer gid;

    private String picPc;

    private String picShrink;

    private String picSquare;

    private Integer sort;

    private Integer reserve1;

    private String reserve2;

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

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }
}