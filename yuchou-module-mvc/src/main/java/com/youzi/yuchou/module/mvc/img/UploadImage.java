package com.youzi.yuchou.module.mvc.img;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.BaseUpdState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.StorageManager;
import com.youzi.yuchou.module.mvc.img.ImgUtil;
import com.youzi.yuchou.module.mvc.utils.MD5Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
	public static final State save(MultipartFile multipartFile,
			Map<String, Object> conf) {
		
		try {

			//默认存放图片地址
			String savePath = (String) conf.get("savePathDefault");
//			//截取图片后存放的地址
//			String savePathChange = (String) conf.get("savePathChange");
//			//压缩后存放的地址
//			String savePathMin = (String) conf.get("savePathMin");
			// /upload/image/ueditor/atricle/   |    /upload/image/goods/d
			savePath = savePath + ImgUtil.imagePathFormat;
			// /upload/image/ueditor/atricle/{yyyy}{mm}{dd}/{time}{rand:6}
			String originFileName = multipartFile.getOriginalFilename(); //17.jpg
			String suffix = FileType.getSuffixByFilename(originFileName);//.jpg
			
			originFileName = originFileName.substring(0,originFileName.length() - suffix.length());//17
			savePath = savePath + suffix;// /upload/image/ueditor/atricle/{yyyy}{mm}{dd}/{time}{rand:6}.jpg
			
			long maxSize = (ImgUtil.maxSize).longValue();//2048000
			
			if (!validType(suffix, ImgUtil.allowFiles)) {
				return new BaseUpdState(false, UplAppInfo.NOT_ALLOW_FILE_TYPE);
			}
			/***********/
			//自定义
			savePath = PathFormat.parse(savePath, originFileName);// /upload/image/ueditor/atricle/20170509/1494295300792008348.jpg
			String [] savePathBySplit_temp = savePath.split("/");
			savePath = "/";
			for(int i = 1;i < savePathBySplit_temp.length-1; i++){
				if(i!=savePathBySplit_temp.length-2){
					savePath+=savePathBySplit_temp[i]+"/";
				}else{
					savePath+=savePathBySplit_temp[i]+"/";
				}
			}
			
			String temp = "";
			String fileName = savePathBySplit_temp[savePathBySplit_temp.length-1];// 1494295300792008348.jpg
			fileName = MD5Util.tool(MD5Util.MD5_min(fileName))+suffix;
			savePath = savePath+fileName;
			for(int i = 2;i < savePathBySplit_temp.length-1; i++){
				if(i!=savePathBySplit_temp.length-2){
					temp+=savePathBySplit_temp[i]+"/";
				}else{
					temp+=savePathBySplit_temp[i];
				}
			}
			//上传图片的服务器地址 temp=image/atricle/20170505
//            String pathTemp = request.getSession().getServletContext().getRealPath(temp); 
			String pathTemp = ImgUtil.getImgFileUrl()+File.separator+temp; // D:/nginx/shangcheng/nginx/html/data/file/upload\image/ueditor/atricle/20170509
			pathTemp = pathTemp.replace("\\", "/");
			System.out.println(pathTemp+","+fileName);
			System.out.println(new File(pathTemp).exists());
			File targetFile = new File(pathTemp);
			if(!targetFile.exists()){  
				targetFile.mkdirs();  
			}
			System.out.println(new File(pathTemp).exists());
			/************/
			State storageState = saveFileByInputStream(multipartFile.getInputStream(),pathTemp+"/"+fileName, maxSize);
			
			if (storageState.isSuccess()) {
				storageState.putInfo("url", PathFormat.format(savePath));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}
			
			return storageState;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return new BaseUpdState(false, UplAppInfo.IO_ERROR);
	}
	

	//savePathMin
	public static String yasuo(String savePath,String savePathMin ,String pathTemp ,String fileName){
//		savePath = savePath + ImgUtil.imagePathFormat;
//		// /upload/image/ueditor/atricle/{yyyy}{mm}{dd}/{time}{rand:6}
//		String originFileName = multipartFile.getOriginalFilename(); //17.jpg
//		String suffix = FileType.getSuffixByFilename(originFileName);//.jpg
//		
//		originFileName = originFileName.substring(0,originFileName.length() - suffix.length());//17
//		savePath = savePath + suffix;// /upload/image/ueditor/atricle/{yyyy}{mm}{dd}/{time}{rand:6}.jpg
		
//		savePath = PathFormat.parse(savePath, originFileName);// /upload/image/ueditor/atricle/20170509/1494295300792008348.jpg
		String [] savePathBySplit_temp = savePath.split("/");
		String temp1 = "/";
		for(int i = savePathBySplit_temp.length-2;i < savePathBySplit_temp.length; i++){
			if(i!=savePathBySplit_temp.length){
				temp1+=savePathBySplit_temp[i]+"/";
			}else{
				temp1+=savePathBySplit_temp[i];
			}
		}
		savePathMin = savePathMin + temp1;
		String [] savePathMinBySplit_temp = savePathMin.split("/");
		String temp = "";
		for(int i = 2;i < savePathMinBySplit_temp.length; i++){
			if(i!=savePathMinBySplit_temp.length-1){
				temp+=savePathMinBySplit_temp[i]+"/";
			}else{
				temp+=savePathMinBySplit_temp[i];
			}
		}
		/*****/
		//原图地址
		String filepath = pathTemp+"/"+fileName;
		//压缩图片地址
		String pathTempMin = ImgUtil.getImgFileUrl()+File.separator+temp; // D:/nginx/shangcheng/nginx/html/data/file/upload\image/ueditor/atricle/20170509
		pathTempMin = pathTempMin.replace("\\", "/");
		
//		BufferedImage bufferedImage = ImageUtil.InputImage(filepath);
		ImageUtil.imageYasuo(filepath, pathTempMin);
//		if(bufferedImage.getWidth()>700 || bufferedImage.getHeight()>700){
//			filepath=pathTempMin;
//		}
//		ImageUtil.imageJiequ(filepath, filepath_intercept, 600);
		/*****/
		return savePathMin;
	}
	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
	
	private static File getTmpFile() {
		File tmpDir = FileUtils.getTempDirectory();
		String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
		return new File(tmpDir, tmpFileName);
	}
	
	public static State saveFileByInputStream(InputStream is, String path,
			long maxSize) {
		State state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[ 2048 ];
		BufferedInputStream bis = new BufferedInputStream(is, StorageManager.BUFFER_SIZE);

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(tmpFile), StorageManager.BUFFER_SIZE);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			if (tmpFile.length() > maxSize) {
				tmpFile.delete();
				return new BaseUpdState(false, UplAppInfo.MAX_SIZE);
			}

			state = saveTmpFile(tmpFile, path);

			if (!state.isSuccess()) {
				tmpFile.delete();
			}

			return state;
			
		} catch (IOException e) {
		}
		return new BaseUpdState(false, UplAppInfo.IO_ERROR);
	}
	private static State saveTmpFile(File tmpFile, String path) {
		State state = null;
		File targetFile = new File(path);

		if (targetFile.canWrite()) {
			return new BaseUpdState(false, UplAppInfo.PERMISSION_DENIED);
		}
		try {
			FileUtils.moveFile(tmpFile, targetFile);
		} catch (IOException e) {
			return new BaseUpdState(false, UplAppInfo.IO_ERROR);
		}

		state = new BaseUpdState(true);
		state.putInfo( "size", targetFile.length() );
		state.putInfo( "title", targetFile.getName() );
		
		return state;
	}
}
