package com.youzi.yuchou.module.redis.service;

import com.youzi.yuchou.module.redis.config.ValueType;

import java.util.List;

public interface RedisProxyService {

	ValueType supportType();

	<T> T find(String key);
	
	/**
	 * 放入redis
	 * @param key   redis   key值
	 * @param object   数据
	 * @param liveTime   存放时间
	 * @return 
	 */
	void set(String key, Object object, final long liveTime);
	
	/**
	 * 根据key删除
	 * @param key
	 */
	void delete(String key);
	
	void deleteKeys(List<String> list);
	 
	/**
	 * 清空redis
	 * @param key
	 */
	void flushDB();
	
	/**
	 * 检查key是否存在
	 * @param key
	 * @return
	 */
	boolean exists(String key);
}
