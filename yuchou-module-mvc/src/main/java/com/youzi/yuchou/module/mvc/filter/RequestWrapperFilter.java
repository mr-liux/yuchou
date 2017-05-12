package com.youzi.yuchou.module.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.youzi.yuchou.module.mvc.support.MultiReadHttpServletRequest;

public class RequestWrapperFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		MultiReadHttpServletRequest wrapped = new MultiReadHttpServletRequest(servletRequest);
		filterChain.doFilter(wrapped, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
