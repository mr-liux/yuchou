package com.youzi.yuchou.module.model.model;

import java.io.Serializable;

public class GoodsItemCat implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer merchantItemCatid;

    private Integer gid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantItemCatid() {
        return merchantItemCatid;
    }

    public void setMerchantItemCatid(Integer merchantItemCatid) {
        this.merchantItemCatid = merchantItemCatid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}