package com.youzi.yuchou.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

	@Value("${druid.loginUsername:admin}")
	private String loginUsername;

	@Value("${druid.loginPassword:admin}")
	private String loginPassword;

	@Value("${druid.resetEnable:true}")
	private String resetEnable;

	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.setServlet(new StatViewServlet());
		registrationBean.addUrlMappings("/druid/*");
		registrationBean.addInitParameter("resetEnable", resetEnable);
		registrationBean.addInitParameter("loginUsername", loginUsername);
		registrationBean.addInitParameter("loginPassword", loginPassword);
		return registrationBean;
	}

}
