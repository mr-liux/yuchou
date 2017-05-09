package com.youzi.yuchou.module.mvc.utils;


import java.security.MessageDigest;
import java.util.Random;

public class MD5Util {

	public static String MD5(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String MD5_min(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将32位字符转换成00000000-0000-0000-0000-000000000000格式
	 * @param str
	 * @return
	 */
	public static String tool(String str) {
		String result=str.substring(0, 8)+"-"+str.substring(8, 12)+"-"+str.substring(12, 16)+"-"+str.substring(16, 20)+"-"+str.substring(20, 32);
		return result.toString();
	}
	/**
	 * 随机生成n位数字字符串
	 * @param n长度
	 * @return
	 */
	public static String random(int n) {
		Random random = new Random();
		String result="";
		for(int i=0;i<n;i++){
			result+=random.nextInt(10);
		}
		return result.toString();
	}
	public static void main(String[] args) {
		//String md5 = MD5Util.MD5("QingYouCloud@66");
		String md5 = MD5Util.MD5("123456");
		System.out.println(md5);
	}
}
