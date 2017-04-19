package com.youzi.yuchou.portal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.youzi.yuchou.module.mvc.interceptor.GateInterceptor;
import com.youzi.yuchou.portal.interceptor.AuthInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GateInterceptor());
		registry.addInterceptor(new AuthInterceptor());
	}

}
