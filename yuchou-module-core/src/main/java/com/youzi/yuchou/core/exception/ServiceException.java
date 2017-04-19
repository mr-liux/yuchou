package com.youzi.yuchou.core.exception;

public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ServiceException() {

	}

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Integer code, String msg) {
		super(code, msg);
	}

	public ServiceException(Integer code, String msg, String log) {
		super(code, msg, log);
	}

}
