package com.youzi.yuchou.admin.web.common;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.ActionEnter;

@RestController
@RequestMapping("/ued")
public class UEditorController extends AdminBaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/config")
	public String  config(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
	        response.setHeader("Content-Type", "text/html");
	        ServletContext application = request.getServletContext();
	        String rootPath = application.getRealPath("/resources/webapp");
	        String result = new ActionEnter(request, rootPath).exec();
	        logger.info(result);
	        return result;
		} catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
}
