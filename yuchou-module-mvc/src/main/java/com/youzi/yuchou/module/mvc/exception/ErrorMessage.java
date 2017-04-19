package com.youzi.yuchou.module.mvc.exception;

import lombok.Data;

@Data
public class ErrorMessage {

	private int code;

	private String messgae;

	public ErrorMessage(int code, String messgae) {
		this.code = code;
		this.messgae = messgae;
	}
}
