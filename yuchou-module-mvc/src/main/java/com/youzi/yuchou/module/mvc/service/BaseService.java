package com.youzi.yuchou.module.mvc.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youzi.yuchou.module.mvc.dto.RestResponse;

public abstract class BaseService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

//	@Autowired
//	protected JdbcTemplate jdbcTemplate;

//	@Autowired
//	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/**
	 * 
	 */
//	@Autowired
//	protected StringRedisTemplate stringRedisTemplate;
//
//	@Autowired
//	protected RedisTemplate<String, Long> longRedisTemplate;
//	
//	@Autowired
//	protected RedisTemplate<Object, Object> objectRedisTemplate;
	
	
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

	
}
