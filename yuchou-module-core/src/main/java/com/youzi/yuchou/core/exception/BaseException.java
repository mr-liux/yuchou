package com.youzi.yuchou.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected Integer code;
	protected String msg;
	protected String log;

	public BaseException() {
	}

	public BaseException(String msg) {
		this.msg = msg;
	}

	public BaseException(Integer code, String msg) {
		this(code, msg, null);
	}

	public BaseException(Integer code, String msg, String log) {
		this.code = code;
		this.msg = msg;
		this.log = log;
	}

}
