package com.youzi.yuchou.module.mvc.dto;

import java.util.HashMap;
import java.util.Map;

import com.youzi.yuchou.module.mvc.common.LocalStaticValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {


    /**
     * 是否成功
     */
    protected boolean   success   = false;
    
	private Integer code = LocalStaticValue.SUCCESS; // 0：成功;其他:失败

	private String message; // 消息

	private T data;

	private Map<String, Object> ext;

	
	/**
	 * 添加额外数据
	 * @param name
	 * @param data
	 */
	public void addExtData(String name, Object data){
		if(ext == null){
			ext = new HashMap<String, Object>();
		}
		ext.put(name, data);
	}
	public void removeExtData(String name){
		if(ext != null){
			ext.remove(name);
		}
	}
	
	public static <T> RestResponse<T> buildSuccessed( T data) {
		return new RestResponse<T>(true, LocalStaticValue.SUCCESS, null, data ,null);
	}
	public static <T> RestResponse<T> buildSuccessed(String resMessage, T data, Map<String, Object> ext) {
		return new RestResponse<T>(true, LocalStaticValue.SUCCESS, resMessage, data ,ext);
	}

	public static <T> RestResponse<T> buildSuccessed(T data, Map<String, Object> ext) {
		return new RestResponse<T>(true, LocalStaticValue.SUCCESS, null, data ,ext);
	}

	public static <T> RestResponse<T> buildDefaultSuccessed(String resMessage) {
		return new RestResponse<T>(true, LocalStaticValue.SUCCESS, resMessage, null,null);
	}

	public static <T> RestResponse<T> buildFailed(Integer code, String message) {
		return new RestResponse<T>(false, code, message, null,null);
	}

	public static <T> RestResponse<T> buildFailed(String resMessage) {
		return new RestResponse<T>(false, 1000, resMessage, null,null);
	}
	public RestResponse(T data, Map<String, Object> ext) {
		super();
		this.data = data;
		this.ext = ext;
	}

}
