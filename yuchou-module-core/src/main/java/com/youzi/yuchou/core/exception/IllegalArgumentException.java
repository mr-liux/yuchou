package com.youzi.yuchou.core.exception;

public class IllegalArgumentException extends BaseException {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentException() {

	}

	public IllegalArgumentException(String msg) {
		super(msg);
	}

	public IllegalArgumentException(Integer code, String msg) {
		super(code, msg);
	}

	public IllegalArgumentException(Integer code, String msg, String log) {
		super(code, msg, log);
	}

}
