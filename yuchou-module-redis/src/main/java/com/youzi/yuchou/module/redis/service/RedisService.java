package com.youzi.yuchou.module.redis.service;

import com.youzi.yuchou.module.redis.config.CacheAutoConfig;
import com.youzi.yuchou.module.redis.config.RedisKey;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by LIUXUAN on 2017/5/10.
 */

public interface RedisService  {


    <T> T findByKey(RedisKey key);

    void put(RedisKey key, Object value) ;
    void flush(RedisKey key);

    void delete(RedisKey key) ;

    void delete(RedisKey key, int index);

    void setApplicationContext(ApplicationContext cxt) throws BeansException;

    boolean exists(RedisKey key) ;




}
