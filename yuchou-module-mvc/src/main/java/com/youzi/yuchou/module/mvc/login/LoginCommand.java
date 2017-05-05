package com.youzi.yuchou.module.mvc.login;


import java.io.Serializable;

public class LoginCommand implements Serializable{
	private static final long serialVersionUID = -4039049913840145509L;

	private String userCode;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
