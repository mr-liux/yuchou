package com.youzi.yuchou.module.redis.service.impl;

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
public class RedisQueueServiceImpl implements RedisProxyService {

	@Resource
	RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public ValueType supportType() {
		return ValueType.QUEUE;
	}

	@Override
	public <T> T find(String key) {
		return (T) redisTemplate.opsForList().range(key, 0, redisTemplate.opsForList().size(key));
	}

	@Override
	public void set(String key, Object object, long liveTime) {
		if(liveTime > 0L)
			redisTemplate.expire(key, liveTime, TimeUnit.SECONDS);
		if(object instanceof List){
			for(Object o : (List<Object>) object){
				redisTemplate.opsForList().rightPush(key, o);
			}
			return;
		}
		redisTemplate.opsForList().rightPush(key, object);
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

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

}
