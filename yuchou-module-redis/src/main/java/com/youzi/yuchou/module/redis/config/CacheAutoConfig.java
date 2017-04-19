package com.youzi.yuchou.module.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@Configuration
@ConditionalOnClass(RedisTemplate.class)
public class CacheAutoConfig {

}
