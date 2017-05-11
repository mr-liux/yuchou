package com.youzi.yuchou.module.mvc.web;

import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youzi.yuchou.module.mvc.dto.RestResponse;

public abstract class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 返回封装好的RestResponse<T> resp
	 * @param resp
	 * @return
	 */
	protected <T> RestResponse<T> buildSuccessed(RestResponse<T> resp) {
		return resp;
	}
	/**
	 * 默认只返回0，成功，null(提示)+data+null(ext)
	 * @param data
	 * @return
	 */
	protected <T> RestResponse<T> buildSuccessed(T data ) {
		return RestResponse.buildSuccessed(data, null);
	}
	/**
	 * 默认只返回0，成功，null(提示)+data+ext
	 * @param data
	 * @param ext
	 * @return
	 */
	protected <T> RestResponse<T> buildSuccessed(T data ,Map<String, Object> ext) {
		return RestResponse.buildSuccessed(data, ext);
	}
	/**
	 * 默认只返回0，成功，信息提示自定义+data
	 * @param message
	 * @param data
	 * @return
	 */
	protected <T> RestResponse<T> buildSuccessed(String message ,T data) {
		return RestResponse.buildSuccessed(message, data, null);
	}
	/**
	 * 默认只返回0，成功，信息提示自定义+data+ext
	 * @param message
	 * @param data
	 * @param ext
	 * @return
	 */
	protected <T> RestResponse<T> buildSuccessed(String message ,T data, Map<String, Object> ext) {
		return RestResponse.buildSuccessed(message, data, ext);
	}

	/**
	 * 默认只返回0，成功，信息提示自定义
	 * @param message
	 * @return
	 */
	protected <T> RestResponse<T> buildDefaultSuccessed(String message) {
		return RestResponse.buildDefaultSuccessed(message);
	}

	/**
	 * 默认1000错误信息
	 * @param message
	 * @return
	 */
	protected <T> RestResponse<T> buildFailed(String message) {
		return RestResponse.buildFailed(1000, message);
	}

	/**
	 * 错误信息自定义
	 * @param code
	 * @param message
	 * @return
	 */
	protected <T> RestResponse<T> buildFailed(Integer code, String message) {
		return RestResponse.buildFailed(code, message);
	}
	
	

}
