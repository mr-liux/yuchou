package com.youzi.yuchou.module.mvc.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.youzi.yuchou.module.mvc.filter.RequestWrapperFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean apiSecurityFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RequestWrapperFilter());
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		return registration;
	}

	@Bean
	public FilterRegistrationBean myFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setOrder(0);
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new ShallowEtagHeaderFilter());
		return registration;
	}
}
