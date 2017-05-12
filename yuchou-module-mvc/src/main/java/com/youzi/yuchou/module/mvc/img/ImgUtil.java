package com.youzi.yuchou.module.mvc.img;
public class ImgUtil {
	private static final String IMG_FILE_URL = "D:/nginx/shangcheng/nginx/html/data/file/upload";
//	private static final String IMG_FILE_URL = "d:/data/image/upload";
	
	/**
	 * 上传大小限制，单位B
	 */
	public static final Long maxSize = 2048000L;
	/**
	 * 自定义保存路径和文件名格式
	 */
	public static final String imagePathFormat = "/{yyyy}{mm}{dd}/{time}{rand:6}";
	/**
	 * 上传图片格式显示
	 */
	public static final String[] allowFiles = new String[]{".png", ".jpg", ".jpeg",  ".bmp"};
	
	/**
	 * 地址
	 * @return
	 */
	public static String getImgFileUrl() {
		return IMG_FILE_URL;
	}

}
