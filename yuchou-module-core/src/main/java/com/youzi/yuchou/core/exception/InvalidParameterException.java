package com.youzi.yuchou.core.exception;

public class InvalidParameterException extends BaseException {

	private static final long serialVersionUID = 1L;

	public InvalidParameterException() {
		this("无效参数");
	}

	public InvalidParameterException(String msg) {
		super(msg);
	}

	public InvalidParameterException(Integer code, String msg) {
		super(code, msg);
	}

	public InvalidParameterException(Integer code, String msg, String log) {
		super(code, msg, log);
	}

}
