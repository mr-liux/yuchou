package com.youzi.yuchou.module.model.model;

import java.io.Serializable;
import java.util.Date;

public class MemberVerify implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer uid;

    private Integer type;

    private String realName;

    private String idCards;

    private String idFrontPic;

    private String idReversePic;

    private Integer enterpriseType;

    private String enterpriseUrl;

    private String enterpriseName;

    private String enterpriseCode;

    private String enterpriseRegnum;

    private String enterpriseNumber;

    private Date enterpriseDate;

    private Integer enterpriseDateType;

    private String enterpriseBankAccount;

    private String enterpriseCardName;

    private String enterpriseBranchName;

    private Integer status;

    private Integer isUserKy;

    private Date addTime;

    private Date updTime;

    private Date releaseTime;

    private String reserve2;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCards() {
        return idCards;
    }

    public void setIdCards(String idCards) {
        this.idCards = idCards == null ? null : idCards.trim();
    }

    public String getIdFrontPic() {
        return idFrontPic;
    }

    public void setIdFrontPic(String idFrontPic) {
        this.idFrontPic = idFrontPic == null ? null : idFrontPic.trim();
    }

    public String getIdReversePic() {
        return idReversePic;
    }

    public void setIdReversePic(String idReversePic) {
        this.idReversePic = idReversePic == null ? null : idReversePic.trim();
    }

    public Integer getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Integer enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseUrl() {
        return enterpriseUrl;
    }

    public void setEnterpriseUrl(String enterpriseUrl) {
        this.enterpriseUrl = enterpriseUrl == null ? null : enterpriseUrl.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEnterpriseRegnum() {
        return enterpriseRegnum;
    }

    public void setEnterpriseRegnum(String enterpriseRegnum) {
        this.enterpriseRegnum = enterpriseRegnum == null ? null : enterpriseRegnum.trim();
    }

    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber == null ? null : enterpriseNumber.trim();
    }

    public Date getEnterpriseDate() {
        return enterpriseDate;
    }

    public void setEnterpriseDate(Date enterpriseDate) {
        this.enterpriseDate = enterpriseDate;
    }

    public Integer getEnterpriseDateType() {
        return enterpriseDateType;
    }

    public void setEnterpriseDateType(Integer enterpriseDateType) {
        this.enterpriseDateType = enterpriseDateType;
    }

    public String getEnterpriseBankAccount() {
        return enterpriseBankAccount;
    }

    public void setEnterpriseBankAccount(String enterpriseBankAccount) {
        this.enterpriseBankAccount = enterpriseBankAccount == null ? null : enterpriseBankAccount.trim();
    }

    public String getEnterpriseCardName() {
        return enterpriseCardName;
    }

    public void setEnterpriseCardName(String enterpriseCardName) {
        this.enterpriseCardName = enterpriseCardName == null ? null : enterpriseCardName.trim();
    }

    public String getEnterpriseBranchName() {
        return enterpriseBranchName;
    }

    public void setEnterpriseBranchName(String enterpriseBranchName) {
        this.enterpriseBranchName = enterpriseBranchName == null ? null : enterpriseBranchName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsUserKy() {
        return isUserKy;
    }

    public void setIsUserKy(Integer isUserKy) {
        this.isUserKy = isUserKy;
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

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }
}