package com.youzi.yuchou.module.mvc.login.domain;

import java.io.Serializable;

public class TokenResponse implements Serializable {
	
	private static final long serialVersionUID = -3259567267416578859L;
	
	private String code;
	private String message;
	private String token;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public TokenResponse() {
		super();
	}
	public TokenResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public TokenResponse(String code, String message, String token) {
		super();
		this.code = code;
		this.message = message;
		this.token = token;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
