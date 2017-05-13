package com.youzi.yuchou.admin.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.youzi.yuchou.admin.common.login.UserTokenManager;
import com.youzi.yuchou.admin.common.login.domain.TokenInfo;
import com.youzi.yuchou.admin.repository.system.SysUserRightsRepository;
import com.youzi.yuchou.core.exception.AuthException;
import com.youzi.yuchou.core.exception.ExceptionStaticEnum;
import com.youzi.yuchou.module.model.model.SysMenu;
import com.youzi.yuchou.module.mvc.annotation.Auth;
import com.youzi.yuchou.module.mvc.common.LocalStaticValue;
import com.youzi.yuchou.module.mvc.utils.NetworkUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
	private SysUserRightsRepository  sysUserRightsRepository;
	
	public AuthInterceptor(SysUserRightsRepository sysUserRightsRepository) {
		super();
		this.sysUserRightsRepository = sysUserRightsRepository;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Auth auth = method.getMethodAnnotation(Auth.class);
			if (auth != null) {
				// TODO 权限校验
				log.info("start auth ...");
				String token = request.getHeader(LocalStaticValue.AUTH_TOKEN);
				String ip = NetworkUtils.getIpAddress(request);
				if (token == null) {
					throw new AuthException(
							ExceptionStaticEnum.ERROR_NO_LOGIN.getCode(),
							ExceptionStaticEnum.ERROR_NO_LOGIN.getMessage());
				} else {
					TokenInfo tokenInfo = UserTokenManager.userTokenMap
							.get(token);
					if (tokenInfo != null) {
						long curTime = System.currentTimeMillis();
						if ((int) (curTime - tokenInfo.getLastVisitTime()) > UserTokenManager.sessionTimeOut * 1000) {
							UserTokenManager.removeToken(token);
							throw new AuthException(
									ExceptionStaticEnum.ERROR_TIMEOUT.getCode(),
									ExceptionStaticEnum.ERROR_TIMEOUT
											.getMessage());
						} else {
							if (ip != null) {
								if (!ip.equals(tokenInfo.getSid())) {
									UserTokenManager.removeToken(token);
									throw new AuthException(
											ExceptionStaticEnum.ERROR_INVALID_SID
													.getCode(),
											ExceptionStaticEnum.ERROR_INVALID_SID
													.getMessage());
								}
							}
							// 更新最后一次访问时间
							UserTokenManager.userTokenMap.get(token)
									.setLastVisitTime(
											System.currentTimeMillis());
							//request.setAttribute(LocalStaticValue.UID,tokenInfo.getUid());
							
							// TODO ... 权限验证
							boolean authMenuStrues = authUserMenu(request ,tokenInfo.getUid().intValue());
							log.info("权限验证  ... 结束 ... userKy:"+tokenInfo.getUid()+",authMenuStrues:"+authMenuStrues);
							if(!authMenuStrues){
								throw new AuthException(
										ExceptionStaticEnum.AUTH_USER_MENU_STATUS.getCode(),
										ExceptionStaticEnum.AUTH_USER_MENU_STATUS.getMessage());
							}  
							
							
						}
					} else {
						throw new AuthException(
								ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN
										.getCode(),
								ExceptionStaticEnum.ERROR_NO_INVALID_TOKEN
										.getMessage());
					}
				}

			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}


	/**
	 * 权限验证
	 */
	public boolean authUserMenu(HttpServletRequest request ,Integer tokenUserKy){
		// 得到用户请求的URI
		log.info("权限验证开始...");
		String request_url = request.getRequestURI();
		log.info("全路径："+request_url);
		// 得到web应用程序的上下文路径
		String ctxPath = request.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String url = request_url.substring(ctxPath.length());
		log.info("截取后路径："+url);
		
		//获取当前登录用户的权限集合
		List<SysMenu> menulist = sysUserRightsRepository.queryMyMenu(tokenUserKy);
/*		for (SysMenu sysMenu : menulist) {
			log.info(sysMenu.getName());
		}*/
		
		String[] urlArr = url.split("/");
		boolean ret = false;
		String url_x = url;
		for (int i = 0; i < urlArr.length-1; i++) {
			if(i == urlArr.length-1){
				ret = authUserMenuListChecked(menulist, url_x);
				break;
			}else{
				ret = authUserMenuListChecked(menulist, url_x);
				url_x = urlsub(url_x);
			}
			if(ret){
				break;
			}
		}
		
		return ret;
	}
	
	public String urlsub(String url){
		log.info("================urlsub=====================");
		int i=url.lastIndexOf("/");
		String url_x = url.substring(0,i);
		log.info("新的url:"+url_x);
		return url_x;
	}
	
	/**
	 * 验证url
	 * @author 背包
	 * @param menulist
	 * @param url
	 * @return
	 */
	public boolean authUserMenuListChecked(List<SysMenu> menulist ,String url ){
		log.info("================authUserMenuListChecked=====================");
		for (SysMenu sysMenu : menulist) {
			
			String m_url = sysMenu.getUrl();
			log.info("界面传入的 url:"+m_url);
			int a=m_url.indexOf("/{");
			if(a>0){
				m_url = m_url.substring(0 , a);
			}
			log.info("数据库查询的url:"+m_url+" 界面传入处理后的 url:"+url);
			if(m_url.equals(url)){
				return true;
			}
		}
		return false; 
	}
}
