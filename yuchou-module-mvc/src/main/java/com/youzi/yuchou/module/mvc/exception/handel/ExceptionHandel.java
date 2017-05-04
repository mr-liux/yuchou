package com.youzi.yuchou.module.mvc.exception.handel;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.google.common.base.Charsets;
import com.youzi.yuchou.core.base.ExceptionUtil;
import com.youzi.yuchou.core.exception.BaseException;
import com.youzi.yuchou.module.mvc.exception.ErrorMessage;

import okio.Okio;

@ControllerAdvice
public class ExceptionHandel {

	Logger logger = LoggerFactory.getLogger("exlog");

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorMessage handelException(HttpServletRequest request, HttpServletResponse response,
			Exception ex) {
		if (ex instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException msrpe = (MissingServletRequestParameterException) ex;
			return buildErrorMessage(String.format("[%s]字段不能为空", msrpe.getParameterName()));
		} else if (ex instanceof NoHandlerFoundException) {
			return buildErrorMessage("404NotFound");
		} else if (ex instanceof BaseException) {
			return buildErrorMessage(((BaseException) ex).getCode(),((BaseException) ex).getMsg());
		} else {
			logger.info(request.getMethod() + request.getServletPath());
			logger.info(request.getQueryString());
			try {
				logger.info(Okio.buffer(Okio.source(request.getInputStream())).readString(Charsets.UTF_8));
			} catch (IOException e) {
				// ignore
			}
			logger.info(ExceptionUtil.stackTraceText(ex));
			return buildErrorMessage("服务异常");
		}
	}

	private ErrorMessage buildErrorMessage(String message) {
		return buildErrorMessage(1000, message);
	}

	private ErrorMessage buildErrorMessage(Integer code, String message) {
		return new ErrorMessage(code, message);
	}

}
