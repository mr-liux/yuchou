package com.youzi.yuchou.module.redis.service.impl;

import com.youzi.yuchou.module.redis.config.RedisKey;
import com.youzi.yuchou.module.redis.config.ValueType;
import com.youzi.yuchou.module.redis.service.RedisProxyService;
import com.youzi.yuchou.module.redis.service.RedisService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LIUXUAN on 2017/5/10.
 */
@Service
public class RedisServiceImpl implements RedisService, ApplicationContextAware {
    private static Map<ValueType, RedisProxyService> cacheMap = new HashMap<ValueType, RedisProxyService>();

    public <T> T findByKey(RedisKey key) {
        if(key == null) return null;
        if(!cacheMap.containsKey(key.getType())) return null;
        return cacheMap.get(key.getType()).find(key.getValue());
    }

    public void put(RedisKey key, Object value) {
        if(key == null) return;
        if(!cacheMap.containsKey(key.getType())) return;
        cacheMap.get(key.getType()).set(key.getValue(), value, 0);
    }

    public void flush(RedisKey key) {
        cacheMap.get(key.getType()).flushDB();
    }

    public void delete(RedisKey key) {
        if(key == null) return;
        if(!cacheMap.containsKey(key.getType())) return;
        cacheMap.get(key.getType()).delete(key.getValue());
    }

    public void delete(RedisKey key, int index) {
        // TODO Auto-generated method stub

    }

    public void setApplicationContext(ApplicationContext cxt) throws BeansException {
        Map<String, RedisProxyService>  beanMap = cxt.getBeansOfType(RedisProxyService.class);
        for(Map.Entry<String, RedisProxyService> entry: beanMap.entrySet()){
            RedisProxyService tmp = entry.getValue();
            cacheMap.put(tmp.supportType(), tmp);
        }
    }

    public boolean exists(RedisKey key) {
        if(key == null) return false;
        if(!cacheMap.containsKey(key.getType())) return true;
        return cacheMap.get(key.getType()).exists(key.getValue());
    }
}
