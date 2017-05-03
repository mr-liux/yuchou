package com.youzi.yuchou.module.model.model;

import java.io.Serializable;

public class MemberShoppingCartSpec implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer cartId;

    private Integer gid;

    private Integer goodsSpecId;

    private Integer goodsSpecDetailId;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGoodsSpecId() {
        return goodsSpecId;
    }

    public void setGoodsSpecId(Integer goodsSpecId) {
        this.goodsSpecId = goodsSpecId;
    }

    public Integer getGoodsSpecDetailId() {
        return goodsSpecDetailId;
    }

    public void setGoodsSpecDetailId(Integer goodsSpecDetailId) {
        this.goodsSpecDetailId = goodsSpecDetailId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}