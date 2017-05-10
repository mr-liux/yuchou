package com.youzi.yuchou.module.redis.service.impl;

import java.util.Date;
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
public class RedisSetServiceImpl implements RedisProxyService {

	@Resource
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public ValueType supportType() {
		return ValueType.SET;
	}

	@Override
	public <T> T find(String key) {
		return (T) redisTemplate.opsForSet().members(key);
	}

	@Override
	public void set(final String key, final Object object, final long liveTime) {
		redisTemplate.opsForSet().add(key, object);
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
		redisTemplate.delete(list);
	}

	public void expireKey(String key) {
		redisTemplate.expireAt(key, new Date());
	}

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	public void deleteValue(String key, Object value) {
		if (StringUtils.isBlank(key) || value == null)
			return;
		redisTemplate.opsForSet().remove(key, value);
	}

	public boolean existsValue(String key, Object value) {
		return (StringUtils.isBlank(key) || value == null) ? false : redisTemplate.opsForSet().isMember(key, value);
	}

}
