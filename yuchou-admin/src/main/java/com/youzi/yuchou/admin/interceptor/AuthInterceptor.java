package com.youzi.yuchou.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.youzi.yuchou.core.exception.AuthException;
import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.common.LocalStaticValue;
import com.youzi.yuchou.module.mvc.login.UserTokenManager;
import com.youzi.yuchou.module.mvc.login.domain.TokenInfo;
import com.youzi.yuchou.module.mvc.utils.NetworkUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Auth auth = method.getMethodAnnotation(Auth.class);
			if (auth != null) {
				// TODO 权限校验
				log.info("start auth ...");
				String token = request.getHeader(LocalStaticValue.AUTH_TOKEN);
				String ip = NetworkUtils.getIpAddress(request);
				if(token==null){
					throw new AuthException(
							ExceptionStaticEnum.ERROR_NO_LOGIN.getCode(),
							ExceptionStaticEnum.ERROR_NO_LOGIN.getMessage());
				}else{
					TokenInfo tokenInfo = UserTokenManager.userTokenMap.get(token);
					if(tokenInfo!=null){
						long curTime = System.currentTimeMillis();
						if((int)(curTime - tokenInfo.getLastVisitTime())>UserTokenManager.sessionTimeOut*1000){
							UserTokenManager.removeToken(token);
							throw new AuthException(
									ExceptionStaticEnum.ERROR_TIMEOUT.getCode(),
									ExceptionStaticEnum.ERROR_TIMEOUT.getMessage());
						}else{
							if(ip!=null){
								if(!ip.equals(tokenInfo.getSid())){
									UserTokenManager.removeToken(token);
									throw new AuthException(
											ExceptionStaticEnum.ERROR_INVALID_SID.getCode(),
											ExceptionStaticEnum.ERROR_INVALID_SID.getMessage());
								}
							}
							//更新最后一次访问时间
							UserTokenManager.userTokenMap.get(token).setLastVisitTime(System.currentTimeMillis());
							request.setAttribute(LocalStaticValue.UID, tokenInfo.getUid());
						}
					}else{
						throw new AuthException(
								ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN.getCode(),
								ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN.getMessage());
					}
				}
				
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
