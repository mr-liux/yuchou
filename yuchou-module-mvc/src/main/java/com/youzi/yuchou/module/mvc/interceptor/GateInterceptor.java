package com.youzi.yuchou.module.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Charsets;
import com.youzi.yuchou.module.mvc.utils.IPAddressUtils;

import okio.Okio;

public class GateInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger("gatelog");

	private static final String REQUEST_START_TIME = "request-start-time";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long start = System.currentTimeMillis();
		request.setAttribute(REQUEST_START_TIME, start);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		Long end = System.currentTimeMillis();
		Long start = (Long) request.getAttribute(REQUEST_START_TIME);

		String method = request.getMethod();
		String URI = request.getServletPath();

		String remoteIp = IPAddressUtils.getRemoteIp(request);

		Long durantion = end - start;

		StringBuilder sb = new StringBuilder(512);
		sb.append(" ");
		sb.append(method);
		sb.append(URI);
		sb.append(" ");
		sb.append(remoteIp);
		sb.append(" ");
		sb.append(durantion);
		sb.append(" ");
		sb.append(response.getStatus());
		sb.append(" ");
		sb.append(request.getQueryString());
		sb.append(" ");
		sb.append(Okio.buffer(Okio.source(request.getInputStream())).readString(Charsets.UTF_8));
		logger.info(sb.toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
