package com.youzi.yuchou.module.redis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.youzi.yuchou.module.redis.config.ValueType;
import com.youzi.yuchou.module.redis.service.RedisProxyService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisSingleServiceImpl implements RedisProxyService {

	@Resource
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public ValueType supportType() {
		return ValueType.SINGLE;
	}

	@Override
	public <T> T find(String key) {
		return (T) redisTemplate.opsForValue().get(key);
	}

	@Override
	public void set(final String key, final Object object, final long liveTime) {
		if(liveTime > 0L){
			redisTemplate.opsForValue().set(key, object, liveTime, TimeUnit.SECONDS);
			return;
		}
		redisTemplate.opsForValue().set(key, object);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void flushDB() {
		redisTemplate.execute(new RedisCallback () {
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

	public void expireKey(String key){
		redisTemplate.expireAt(key, new Date());
	}

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

}
