package com.youzi.yuchou.core.exception;

public class AuthException extends BaseException {

	private static final long serialVersionUID = 1L;

	public AuthException() {
		super();
	}

	public AuthException(Integer code, String msg, String log) {
		super(code, msg, log);
	}

	public AuthException(Integer code, String msg) {
		super(code, msg);
	}

	public AuthException(String msg) {
		super(msg);
	}

}
