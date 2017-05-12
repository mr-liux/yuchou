package com.youzi.yuchou.module.model.model;

import java.io.Serializable;

public class GoodsCredit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer gid;

    private Double desTotal;

    private Double desAveScore;

    private Integer desNumScores;

    private Double priceTotal;

    private Double priceAveScore;

    private Integer priceNumScores;

    private Double goodsTotal;

    private Double goodsAveScore;

    private Integer goodsNumScores;

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

    public Double getDesTotal() {
        return desTotal;
    }

    public void setDesTotal(Double desTotal) {
        this.desTotal = desTotal;
    }

    public Double getDesAveScore() {
        return desAveScore;
    }

    public void setDesAveScore(Double desAveScore) {
        this.desAveScore = desAveScore;
    }

    public Integer getDesNumScores() {
        return desNumScores;
    }

    public void setDesNumScores(Integer desNumScores) {
        this.desNumScores = desNumScores;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Double getPriceAveScore() {
        return priceAveScore;
    }

    public void setPriceAveScore(Double priceAveScore) {
        this.priceAveScore = priceAveScore;
    }

    public Integer getPriceNumScores() {
        return priceNumScores;
    }

    public void setPriceNumScores(Integer priceNumScores) {
        this.priceNumScores = priceNumScores;
    }

    public Double getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(Double goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public Double getGoodsAveScore() {
        return goodsAveScore;
    }

    public void setGoodsAveScore(Double goodsAveScore) {
        this.goodsAveScore = goodsAveScore;
    }

    public Integer getGoodsNumScores() {
        return goodsNumScores;
    }

    public void setGoodsNumScores(Integer goodsNumScores) {
        this.goodsNumScores = goodsNumScores;
    }
}