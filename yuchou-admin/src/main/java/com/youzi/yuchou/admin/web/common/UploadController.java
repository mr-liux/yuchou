package com.youzi.yuchou.admin.web.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.define.State;
import com.youzi.yuchou.module.mvc.img.UploadImage;

@RestController
@RequestMapping("/upload")
public class UploadController extends AdminBaseController {

protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/image/goods")
	public String image(@RequestParam("fieldname")MultipartFile file) {
		try {
			Map<String, Object> conf = new HashMap<String, Object>();
//			conf.put("filedName", "filedName");
			//默认存放图片地址
			conf.put("savePathDefault", "/upload/image/goods/d");
			//截取图片后存放的地址
			conf.put("savePathChange", "/upload/image/goods/c");
			//压缩后存放的地址
			conf.put("savePathMin", "/upload/image/goods/m");
			
			State state = UploadImage.save(file, conf);
			String result =state.toJSONString();
			logger.info(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
}
