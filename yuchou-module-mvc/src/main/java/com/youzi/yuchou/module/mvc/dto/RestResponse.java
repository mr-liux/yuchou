package com.youzi.yuchou.module.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

	private Integer code = 0; // 0：成功;其他:失败

	private String messgae; // 消息

	private T data;

	public static <T> RestResponse<T> buildSuccessed(String resMessage, T data) {
		return new RestResponse<T>(0, resMessage, data);
	}

	public static <T> RestResponse<T> buildSuccessed(T data) {
		return new RestResponse<T>(0, null, data);
	}

	public static <T> RestResponse<T> buildDefaultSuccessed(String resMessage) {
		return new RestResponse<T>(0, resMessage, null);
	}

	public static <T> RestResponse<T> buildFailed(Integer code, String message) {
		return new RestResponse<T>(code, message, null);
	}

	public static <T> RestResponse<T> buildFailed(String resMessage) {
		return new RestResponse<T>(1000, resMessage, null);
	}

}
