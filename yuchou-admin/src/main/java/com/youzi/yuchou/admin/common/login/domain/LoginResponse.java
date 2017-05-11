package com.youzi.yuchou.admin.common.login.domain;


import java.io.Serializable;
import java.util.List;


public class LoginResponse implements Serializable
{


	private static final long serialVersionUID = -3709909249824766322L;

	private int loginResult;

	private String userCode;

	private String token;

	private List<String> rightList;

	public int getLoginResult() {

		return loginResult;
	}

	public void setLoginResult(int loginResult) {

		this.loginResult = loginResult;
	}

	public String getUserCode() {

		return userCode;
	}

	public void setUserCode(String userCode) {

		this.userCode = userCode;
	}

	public String getToken() {

		return token;
	}

	public void setToken(String token) {

		this.token = token;
	}

	public List<String> getRightList() {

		return rightList;
	}

	public void setRightList(List<String> rightList) {

		this.rightList = rightList;
	}
}
