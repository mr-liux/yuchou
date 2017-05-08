package com.youzi.yuchou.module.mvc.exception;

import lombok.Data;

@Data
public class ErrorMessage {

	private int code;

	private String message;

	public ErrorMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
