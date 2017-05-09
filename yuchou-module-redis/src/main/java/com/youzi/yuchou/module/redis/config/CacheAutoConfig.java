package com.youzi.yuchou.module.redis.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@EnableCaching
@Configuration
@ConditionalOnClass(RedisTemplate.class)
public class CacheAutoConfig implements ApplicationContextAware {

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
