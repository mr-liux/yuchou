package com.youzi.yuchou.module.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youzi.yuchou.core.mapper.JsonMapper;

@Configuration
public class ApplicationConfig {

	@Bean
	public JsonMapper jsonMapper(ObjectMapper mapper) {
		JsonMapper jsonMapper = JsonMapper.INSTANCE;
		jsonMapper.setMapper(mapper);
		return jsonMapper;
	}

}
