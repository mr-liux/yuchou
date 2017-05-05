package com.youzi.yuchou.module.mvc.login.domain;

import java.io.Serializable;

public class TokenResponse implements Serializable {
	
	private static final long serialVersionUID = -3259567267416578859L;
	
	private String code;
	private String messgae;
	
	public TokenResponse() {
		super();
	}
	public TokenResponse(String code, String messgae) {
		super();
		this.code = code;
		this.messgae = messgae;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	
}
