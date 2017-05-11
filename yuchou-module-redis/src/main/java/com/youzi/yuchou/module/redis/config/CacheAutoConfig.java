package com.youzi.yuchou.module.redis.config;

import com.youzi.yuchou.module.redis.service.RedisProxyService;
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
public class CacheAutoConfig {

}
