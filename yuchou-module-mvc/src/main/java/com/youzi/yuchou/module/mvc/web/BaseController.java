package com.youzi.yuchou.module.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youzi.yuchou.module.mvc.dto.RestResponse;

public abstract class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected <T> RestResponse<T> buildSuccessed(T data) {
		return RestResponse.buildSuccessed(data);
	}

	protected <T> RestResponse<T> buildSuccessed(T data, String message) {
		return RestResponse.buildSuccessed(message, data);
	}

	protected <T> RestResponse<T> buildDefaultSuccessed(String message) {
		return RestResponse.buildDefaultSuccessed(message);
	}

	protected <T> RestResponse<T> buildFailed(String message) {
		return RestResponse.buildFailed(1000, message);
	}

	protected <T> RestResponse<T> buildFailed(Integer code, String message) {
		return RestResponse.buildFailed(code, message);
	}

}
