package com.youzi.yuchou.module.redis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.youzi.yuchou.module.redis.config.ValueType;
import com.youzi.yuchou.module.redis.service.RedisProxyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
@SuppressWarnings("unchecked")
public class RedisMapServiceImpl implements RedisProxyService {

	@Resource
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public ValueType supportType() {
		return ValueType.MAP;
	}

	@Override
	public <T> T find(String key) {
		return (T) redisTemplate.opsForHash().entries(key);
	}

	public <T> T findValue(String key, Object hashKey) {
		if(StringUtils.isBlank(key) || hashKey == null) return null;
		return (T) redisTemplate.opsForHash().get(key, hashKey);
	}

	@Override
	public void set(final String key, final Object object, final long liveTime) {
//		throw new BussinessException("this class doesn't support the method named set");
	}

	public void put(final String key, final Object hashKey, Object value) {
		if (StringUtils.isBlank(key) || hashKey == null)
			return;
		if (!redisTemplate.opsForHash().hasKey(key, hashKey)) {
			redisTemplate.opsForHash().put(key, hashKey, value);
		}
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void flushDB() {
		redisTemplate.execute(new RedisCallback<Object>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	@Override
	public void deleteKeys(List<String> list) {
//		throw new BussinessException("this class doesn't support the method named deleteKeys");
	}

	public void deleteEntry(String key, Object hashKey) {
		redisTemplate.opsForHash().delete(key, hashKey);
	}

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	public boolean existsHashKey(String key, Object hashKey) {
		return redisTemplate.opsForHash().hasKey(key, hashKey);
	}

}
