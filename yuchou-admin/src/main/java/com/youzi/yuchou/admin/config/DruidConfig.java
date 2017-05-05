package com.youzi.yuchou.admin.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.youzi.yuchou.module.mvc.login.UserTokenManager;

@Configuration
public class DruidConfig {

	@Value("${druid.loginUsername:admin}")
	private String loginUsername;


	@Value("${druid.loginPassword:admin}")
	private String loginPassword;
 
	@Value("${druid.resetEnable:true}")
	private String resetEnable;
	
	@Value("${login.admin.startErrorLocked:false}")
	public  boolean startErrorLocked;
	
	@Value("${login.admin.errorLoginLockedTime:10}")
	public  Integer errorLoginLockedTime;
	
	
	@Value("${login.admin.errorCountLimit:3}")
	public  Integer errorCountLimit;
	
	@Value("${login.admin.sessionTimeOut:600}")
	public  Integer sessionTimeOut;
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		//测试
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
	
	@PostConstruct
	public void run(){
		UserTokenManager.startErrorLocked=startErrorLocked;
		UserTokenManager.errorLoginLockedTime=errorLoginLockedTime;
		UserTokenManager.errorCountLimit=errorCountLimit;
		UserTokenManager.sessionTimeOut=sessionTimeOut;
	}
}
