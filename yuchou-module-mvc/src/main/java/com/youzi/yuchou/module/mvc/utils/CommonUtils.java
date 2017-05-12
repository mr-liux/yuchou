
package com.youzi.yuchou.module.mvc.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;



public class CommonUtils {
	
	public static String getUUID()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase();
	};

	public static BigDecimal bigDecimal(Object val){
		return new BigDecimal(val+"");
	}
	
	/**
	 * 获取当前时间  Date
	 * @author 背包
	 * @return
	 */
	public static Date getDataTime(){
		return new Date();
	}
	
	/**
	 * 取出字符串 [1,2,3]中最大值
	 * */
	public static int getMaxValue(String str) {
		int max = 0;
		// String values=null;
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] strs = str.split(",");
		for (String s : strs) {
			if (max < Integer.parseInt(CommonUtils.trim(s))) {
				max = Integer.parseInt(CommonUtils.trim(s));
			}
		}
		return max;
	}

	/**
	 * 判断字符串数组中是否包含某字符串元素
	 * @return
	 */
	public static boolean isIn(String substring, String[] source) {
		for (int i = 0; i < source.length; i++) {
			if (source[i].trim().equals(substring)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 给数组添加元素
	 * @return
	 */
	public static String[] isInto(String substring, String[] source) {
//		String substring="";
		for (int i = 0; i < source.length; i++) {
			substring+=source[i]+",";
		}
		return substring.split(",");
	}
	/**
	 * 给数组添加元素
	 * @return
	 */
	public static String[] isIntoto(String[] source, String[] source2) {
		String substring="";
		for (int i = 0; i < source.length; i++) {
			substring+=source[i]+",";
		}
		for (int i = 0; i < source2.length; i++) {
			substring+=source2[i]+",";
		}
		
		
		return substring.split(",");
	}
	/**
	 * 给数组去除重复元素
	 * @return
	 */
	public static String[] isInRemove(String[] source) {
		String substring="";
		if(source!= null || source.length>0){
			Set<String> set = new HashSet<String>();
			for(String i : source){
				set.add(i);
			}
			for (String str : set) {  
//		      System.out.println(str); 
				substring+=str+",";
			} 
//		System.err.println("ok:"+substring);
		}
		return substring.split(",");
	}
	/**
	 * 对list检查是否包含某元素
	 * @throws Exception
	 */
	public static boolean isItEquals(List list, String str) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			if (str.trim().equals(list.get(i).toString())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 返回一个整数
	 * @author liuy
	 *  @param str
	 *  @return
	 *  @throws Exception
	 * @return Integer
	 * @date 2014-4-10 下午5:39:52
	 */
	public static Integer isInteger(double str) throws Exception {
		int in=0;
//		double in2=1/(double)str;
		if(str<1){
			in=in+1;
		}
		else if(str>=1){
			int ioo=(int)str;
			in=ioo+1;
		}
		return in;
	}

	
	

	/**
	 * //保留小数点后3位（四舍五入），且不按科学计数法输出
	 * */
	public static String FormatPrice(double price, int i) {
		String revalue = null;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(i);
		df.setMinimumFractionDigits(i);
		revalue = df.format(price);
		revalue = revalue.replaceAll(",", "");
		return revalue;
	}


	/**
	 * 判断字符串是否是GB2312编码的
	 * */
	public static boolean isGB2312(String str) {
			if (CommonUtils.isObjectNotEmpty(str)) {
				return java.nio.charset.Charset.forName("GB2312").newEncoder().canEncode(str);
			} else {
				return false;
			}
	}

	/**
	 * 获得字符串的实际长度 GBK 编码格式 中文占两个字节
	 * */
	public static int getStrLenth(String str) {
			if (str == null || str.length() < 0) {
				return 0;
			}
			int len = 0;
			char c;
			for (int i = str.length() - 1; i >= 0; i--) {
				c = str.charAt(i);
				if (c > 255) {
					len += 2;
				} else {
					len++;
				}
			}
			return len;
	}
	/**
	 * 冒泡排序
	 * 
	 * @param list
	 *            需要排序的集合
	 * @param type
	 *            排序类型 0：正序 1：倒序
	 * */
	public static List<String> setValue(List<String> list, int type) {
		for (int i = 0; i < list.size(); i++) {// 循环List集合，开始于下标0
			for (int j = i + 1; j < list.size(); j++) {// 循环List集合，开始于下标0+1
				int a = Integer.parseInt(list.get(i));// 取List集合的第n个值
				int b = Integer.parseInt(list.get(j));// 取List集合的第n+1个值
				if (type == 0 ? a > b : a < b) {// 如果a比b大，则替换两个值的位置。
					list.set(i, b + "");
					list.set(j, a + "");
				}
			}
		}
		return list;
	}
	/**
	 * 冒泡排序升序
	 * 
	 * @param list
	 *            需要排序的集合
	 * */
	public static String listString(Map<String,String> reqMap){
		 List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(reqMap.entrySet());
		String str="";
		if(list.size()!=0){
	     Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
	  	   //升序排序
	         public int compare(Entry<String, String> o1,Entry<String, String> o2) {
	             return o1.getKey().compareTo(o2.getKey());
	         }
		 
	     });
	     for (int i = 0; i < list.size(); i++) {
	     	str=str+list.get(i).getKey()+"="+list.get(i).getValue();
				if(i<list.size()-1){
					str=str+"&";
				}
			}
		}
	     return str;
	}
	/**
	 * 返回两数之和
	 * @param a1
	 * @param a2
	 * @return a1+a2
	 */
	public static BigDecimal nwdBcadd(Object a1,Object a2) {
		BigDecimal accrual1=new BigDecimal(a1.toString());
		BigDecimal accrual2=new BigDecimal(a2.toString());
		BigDecimal accrual=accrual1.add(accrual2);
		return accrual;
	}
	/**
	 * 返回两数之差
	 * @param a1
	 * @param a2
	 * @return a1-a2
	 */
	public static BigDecimal nwdBcsub(Object a1,Object a2) {
		BigDecimal accrual1=new BigDecimal(a1.toString());
		BigDecimal accrual2=new BigDecimal(a2.toString());
		BigDecimal accrual=accrual1.subtract(accrual2);
		return accrual;
	}
	/**
	 * 返回两数之积
	 * @param a1
	 * @param a2
	 * @return a1*a2
	 */
	public static BigDecimal nwdMultiply(Object a1,Object a2) {
		BigDecimal accrual1=new BigDecimal(a1.toString());
		BigDecimal accrual2=new BigDecimal(a2.toString());
		BigDecimal accrual=accrual1.multiply(accrual2);
		return accrual;
	}
	/**
	 * 返回两数相除
	 * @param a1
	 * @param a2
	 * @return a1/a2
	 */
	public static BigDecimal nwdDivide(Object a1,Object a2) {
		MathContext mc = new MathContext(10, RoundingMode.HALF_DOWN); //取字符个数为10
		BigDecimal accrual1=new BigDecimal(a1.toString());
		BigDecimal accrual2=new BigDecimal(a2.toString());
		BigDecimal accrual=accrual1.divide(accrual2,mc);  
		return accrual;
	}
	/**
	 * 返回小数点后2位  四舍五入
	 * @param object
	 * @return .00
	 */
	public static BigDecimal setScalef(Object object){
		BigDecimal bd = new  BigDecimal(object.toString());  
	    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);   // 取小数点后2位   /ROUND_HALF_UP
	    return bd;
	}
	/**
	 * 返回小数点后2位  
	 * @param object
	 * @return .00
	 */
	public static BigDecimal setScale(Object object){
		BigDecimal bd = new  BigDecimal(object.toString());  
		bd = bd.setScale(2,BigDecimal.ROUND_DOWN);   // 取小数点后2位   /ROUND_HALF_UP
		return bd;
	}
	/**
	 * 返回小数点后X位  
	 * @param object
	 * @return .00
	 */
	public static BigDecimal setScaleX(Object object,int x){
		BigDecimal bd = new  BigDecimal(object.toString());  
		bd = bd.setScale(x,BigDecimal.ROUND_DOWN);   // 取小数点后2位   /ROUND_HALF_UP
		return bd;
	}
	
	/**
	 * 返回小数点后0位  
	 * @param object
	 * @return .00
	 */
	public static BigDecimal setScale0(Object object){
		BigDecimal bd = new  BigDecimal(object.toString());  
		bd = bd.setScale(0,BigDecimal.ROUND_DOWN);   // 取小数点后2位   /ROUND_HALF_UP
		return bd;
	}
	
	/**
	 * 将字符串数字转化为int型数字
	 * @param str被转化字符串
	 * @param defValue转化失败后的默认值
	 * @return int
	 */
	public static int parseInt(String str, int defValue) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	 /**
     * DecimalFormat转换最简便
     */
    public void m2() {
        DecimalFormat df = new DecimalFormat("#.00");
    }
    /**
     * String.format打印最简便
     */
    public void m3(double  f) {
        System.out.println(String.format("%.2f", f));
    }
    /**
     * 111,231.56 
     * @param f
     */
    public void m4(double  f) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
	public static long parseLong(String str, long defValue) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static Long strToLong(String str, Long defValue) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 将字符串数字转化为double型数字
	 * @param str被转化字符串
	 * @param defValue转化失败后的默认值
	 * @return double
	 */
	public static double parseDouble(String str, double defValue) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 检测字符串是否为空
	 */
	public static boolean strIsNull(String str) {
		return ((str == null) || "".equals(str) || "null".equalsIgnoreCase(str));
	}

	/**
	 * 去空格，如为null则转化为空字符串
	 */
	public static String trim(String str) {
		if (str == null || "null".equalsIgnoreCase(str) || "undefined".equalsIgnoreCase(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "'a','b','c'"
	 */
	public static String getRecordIds(String[] recordIds) {
		if (recordIds == null || recordIds.length == 0)
			return "";
		if (recordIds.length == 1)
			return recordIds[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < recordIds.length; i++) {
			if (i == recordIds.length - 1) {
				ids.append("'" + recordIds[i] + "'");
			} else {
				ids.append("'" + recordIds[i] + "'" + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrs(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i]);
			} else {
				ids.append(strs[i] + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrsRep(String[] strs, String rep, String newStr) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i].replace(rep, newStr));
			} else {
				ids.append(strs[i].replace(rep, newStr) + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrsBySplit(String[] strs, String split) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i]);
			} else {
				ids.append(strs[i] + split);
			}
		}
		return ids.toString();
	}

	/**
	 * 验证EMAIL方法
	 * @param str 被验证的email字符串
	 * @return 成功返回true 失败返回false
	 */
	public static boolean isEmail(String str) {
			if (str == null)
				return false;
			str = str.trim();
			if (str.length() < 6)
				return false;
			return true;
	}

	public static boolean isEmail(String value, String expression) {
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(value);
			return matcher.find();
	}

	/**
	 * 在不足len位的数字前面自动补零
	 */
	public static String getLimitLenStr(String str, int len) {
		if (str == null) {
			return "";
		}
		while (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 字符串GBK到UTF-8码的转化
	 * @param inStr
	 *            GBK编码的字符串
	 * @return UTF-8编码的字符串
	 */
	public static String wapGbkToUtf(String inStr) {
		char temChr;
		int ascInt;
		int i;
		String result = new String("");
		if (inStr == null) {
			inStr = "";
		}
		for (i = 0; i < inStr.length(); i++) {
			temChr = inStr.charAt(i);
			ascInt = temChr + 0;
			if (ascInt > 255) {
				result = result + "&#x" + Integer.toHexString(ascInt) + ";";
			} else {
				result = result + temChr;
			}
		}
		return result;
	}

	/**
	 * 特殊字符替换
	 */
	public static String replaceStrHtml(String inStr) {
		String result = inStr;
		if (result != null && !("".equals(result))) {
			result = result.replaceAll("\r\n", "<br>");
			result = result.replaceAll(" ", "&nbsp;");
		}
		return result;
	}

	/**
	 * 特殊字符&替换&amp;
	 */
	public static String replaceStrForWap(String inStr) {
		String result = inStr;
		if (!CommonUtils.strIsNull(inStr)) {
			result = result.replaceAll("&amp;", "&");
			result = result.replaceAll("&", "&amp;");
		}
		return result;
	}

	/**
	 * 判断对象是否为null或""(条件成立则返回ture,否则返回false)
	 * @param objects
	 * @return
	 */
	public static boolean isObjectEmpty(Object objects) {
		if (objects == null || "".equals(objects)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否不为null或""(条件成立则返回ture,否则返回false)
	 * @param objects
	 * @return
	 */
	public static boolean isObjectNotEmpty(Object objects) {
		return !isObjectEmpty(objects);
	}

	// ------------------------------用户请求数据-----------------------------------

	/**
	 * 得到当前请求的URL
	 * @param request
	 * @return
	 */
	public static String getActionURL(HttpServletRequest req) {
		// 请求地址
		String hearderString = req.getHeader("referer");
		String path = req.getContextPath();
		Integer port = req.getServerPort();
		StringBuffer sbf = new StringBuffer();
		if (port.compareTo(80) != 0) {
			sbf.append(req.getScheme()).append("://").append(req.getServerName()).append(":").append(req.getServerPort() + path).append("/");
		} else {
			sbf.append(req.getScheme()).append("://").append(req.getServerName()).append(path).append("/");
		}
		return hearderString.substring(sbf.length());
	}

	/**
	 * 得到客户端请求IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		try {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				if (ip.equals("127.0.0.1")) {
					// 根据网卡取本机配置的IP
					InetAddress inet = InetAddress.getLocalHost();
					ip = inet.getHostAddress();
					System.out.println("ip===="+ip);
					// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
					if (ip != null && ip.length() > 15) { // "***.***.***.***".length() = 15
						if (ip.indexOf(",") > 0) {
							ip = ip.substring(0, ip.indexOf(","));
						}
					}
				}
			}
			if (ip != null && ip.length() > 15) { // "***.***.***.***".length() = 15
				if (ip.indexOf(",") > 0) {
					ip = ip.substring(0, ip.indexOf(","));
				}
			}
			return ip;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    
   /**
* 获取客户端源端口
* @param request
* @return
*/
   public static Long getRemotePort(final HttpServletRequest request){
       try{
           String port = request.getHeader("remote-port");
           if(!StringUtil.isNullOrEmpty(port)) {
		       try{
		           return Long.parseLong(port);
		       }catch(NumberFormatException ex){
		               return 0l;
		       }
	       }else{
	           return 0l;
	       }       
	   }catch(Exception e){
	           return 0l;
       }
   }
	/***
	 * 获取IP
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// Cookie 数据获得
	public static String getCookieValue(Cookie[] cookies, String str) {
		String result = null;
		if (CommonUtils.isObjectNotEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(str)) {
					result = cookie.getValue();
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 获取指定名字的Cookie值，找不到则返回null
	 * @return 成功返回 Cookie的值, 否则返回 null
	 */
	public static String getCookie(HttpServletRequest req, String cookieName) {
		String result = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				cookie.setPath("/");
				if (cookieName.equals(cookie.getName())) {
					result = cookie.getValue();
					break;
				}
			}
		}
		return result;
	}


	// -------------------------日期处理----------------------------------------------

	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @param 输入日期
	 * @param 输入转换
	 *            (规则)格式
	 * @return 返回日期字符串
	 */

	public static String format(Date date, String format) {
		if (date == null || date.equals(""))
			return null;
		SimpleDateFormat sft = new SimpleDateFormat(format);
		return sft.format(date);
	}

	/**
	 * @param 输入字符型日期
	 *            ,如:2007-2-20
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 * @return 返回日期
	 * @throws ParseException
	 */
	public static Date parse(String date, String format) throws ParseException {
		SimpleDateFormat sft = new SimpleDateFormat(format);
		return sft.parse(date);
	}
	/**
	 * 得到两个日期之间的分钟 time1>time2
	 * @param time1 Date
	 * @param time2 Date
	 * @return
	 * @throws ParseException
	 */
	public static long getNewDateTime(Date date1,Date date2) throws ParseException{
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long fen = 0;
		fen=time1-time2;
		fen = fen/1000/60;
		return fen;
		
	}
	/**
	 * 得到两个日期之间的天数 time1>time2
	 * @param time1yyyy-MM-dd
	 * @param time2yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static long getQuot(String time1, String time2)  throws ParseException{
		  long quot = 0;
		  SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		  Date date1 = ft.parse( time1 );
		  Date date2 = ft.parse( time2 );
		  quot = date1.getTime() - date2.getTime();
		  quot = quot / 1000 / 60 / 60 / 24;
		  return quot;
		 }
	/**
	 * 得到两个日期之间的天数 time1>time2
	 * @param time1yyyy-MM-dd
	 * @param time2yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static double getQuotFormatStr(String time1, String time2)  throws ParseException{
		double quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = ft.parse( time1 );
		Date date2 = ft.parse( time2 );
		quot = date1.getTime() - date2.getTime();
		quot = quot / 1000 / 60 / 60 / 24;
		return quot;
	}
	/**
	 * 得到两个日期之间的天数 time1>time2
	 * @param time1yyyy-MM-dd
	 * @param time2yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static double getQuotFormat(Date date1, Date date2)  throws ParseException{
		double quot = 0;
//		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date1 = ft.parse( time1 );
//		Date date2 = ft.parse( time2 );
		quot = date1.getTime() - date2.getTime();
		quot = quot / 1000 / 60 / 60 / 24;
		return quot;
	}
	
	/**
	 * 得到两个年之间的年数 time1>time2
	 * @param time1 Date
	 * @param time2 Date
	 * @return
	 * @throws ParseException
	 */
	public static Integer getQuotAge(Date date1, Date date2)  throws ParseException{
		Integer quot = 0;
//		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = ft.parse( time1 );
//		Date date2 = ft.parse( time2 );
		quot = date1.getYear() - date2.getYear();
		return quot;
	}
	/**
	 * 得到日期字符串
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static String getStrDatetime(Date time)  throws ParseException{
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ft.format(time);
	}
	/**
	 * 得到日期字符串
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static String getStrDayDatetime(Date time ,String str)  throws ParseException{
		SimpleDateFormat ft = new SimpleDateFormat(str);
		String a=ft.format(time);
		a=a.substring(0,8)+"01";
		return a;
	}
	/**
	 * 获得系统当前时间,以分隔符"-"分开
	 * @return返回当前系统日期 如:当前时间是2007年10月15日 则通过该函数得到的字符串为"2007-10-15"
	 */
	public String getToday() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyy-MM-dd");
	}
	public static String getToday2() {
		GregorianCalendar gc = new GregorianCalendar();
		return format(gc.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 获得系统当前时间,以分隔符"-"分开
	 * @return返回当前系统时间 如:当前时间是2007年10月15日21点45分25秒
	 *                 则通过该函数得到的字符串为"2007-10-15-21-45-25"
	 */
	public String getTimeNoSeparate() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyy-MM-dd HH-mm-ss");
	}

	/**
	 * 获得当前系统时间字符串
	 * @return 返回当前系统时间字符串,精确到秒 如:当前时间是2007年10月15日21点45分25秒
	 *         则通过该函数得到的字符串为"20071015214525"
	 */
	public static String getTime() {
		GregorianCalendar gc = new GregorianCalendar();
		return format(gc.getTime(), "yyyyMMddHHmmsssss");
	}
	
	public static String getTime2() {
		GregorianCalendar gc = new GregorianCalendar();
		return format(gc.getTime(), "yyyyMMddHHmmss");
	}

	/**
	 * 获得当前日期字符串,格式:20071015
	 * @return 当前日期字符串
	 */
	public String getNow() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyyMMdd");
	}

	/**
	 * 获得当前日期Date
	 * @return Date
	 */
	public Date getDate() {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.getTime();
	}

	/**
	 * 得到当前时间加上多少分钟以后的时间
	 * @param minute
	 * @return
	 */
	public long getTimeMillisOfAddMinute(Long num, int minute) {
		Long t = num + minute * 1000 * 60;
		return t;
	}

	/**
	 * 获得当前时间Timestamp类型
	 */
	public static Timestamp getNowTime() {
		GregorianCalendar gc = new GregorianCalendar();
		Timestamp time = new Timestamp(gc.getTimeInMillis());
		return time;
	}

	/**
	 * @param 输入字符型日期
	 *            ,如:2007-2-20
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 * @return 返回日期
	 */
	public Date format(String str, String format) {
		Date result = null;
		try {
			str += " ";
			int endStr = str.indexOf(" ");
			String dateString = str.substring(0, endStr);
			result = this.parse(str, format);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 得到当前时间
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getNow(String format) {
		Calendar cal = Calendar.getInstance();
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少天以前的日期(负数表示多少天以后的日期)
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getDayNumOfDate(int dayNum, String format) {
		int day = -dayNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少天以前的日期(负数表示多少天以后的日期)
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public Date getDayNumOfDate(int dayNum) {
		int day = -dayNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 得到指定的日期以前多少天
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getDayNumOfAppointDate(Date appointDate, int dayNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DATE, -dayNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到指定的日期以前多少天  (如得到指定多少天后的日期 dayNum 必须为负)
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public static Date getDayNumOfAppointDate(Date appointDate, int dayNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DATE, -dayNum);
		return cal.getTime();
	}

	/**
	 * 得到指定的日期以前多少天
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getMonthNumOfAppointDate(Date appointDate, int monthNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.MONTH, -monthNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 根据指定的日期得到多少个月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public static Date getMonthNumOfAppointDate(Date appointDate, int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DAY_OF_MONTH, -monthNum);
		return cal.getTime();
	}
	
	/**
	 * 根据指定的日期得到多少个月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public static Date getMonthNumOfDate(Date appointDate, int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.MONTH, monthNum);
		return cal.getTime();
	}

	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getMonthNumOfMonth(int monthNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, monthNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getMonthNumOfMonth(int monthNum, int dateNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -monthNum);
		cal.add(Calendar.DATE, -dateNum);
		return this.format(cal.getTime(), format);
	}
	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public Date getMonthNumOfMonth1(int monthNum, int dateNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -monthNum);
		cal.add(Calendar.DATE, -dateNum);
		return cal.getTime();
	}
	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public static Date getMonthNumOfMonth1(Date appointDate,int monthNum, int dateNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.MONTH, -monthNum);
		cal.add(Calendar.DATE, -dateNum);
		return cal.getTime();
	}
	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getMonthNumOfMonth2(Date appointDate,int monthNum, int dateNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.MONTH, -monthNum);
		cal.add(Calendar.DATE, -dateNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少年以前的日期
	 * 
	 * @param输入int型
	 * @param 输入字符型日期的排列规则
	 *            ,如:yyyy-MM-dd,MM/dd/yyyy. 根据上述输入字符型日期,此处应填写的规则是:yyyy-MM-dd
	 */
	public String getYearNumOfYear(int yearNum, String format) {
		int year = -yearNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, year);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到上一月的第一天
	 * @param format
	 * @return
	 */
	public String getStartOfLastMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到第num个月后的第一天(负数表示前,正为后)
	 * @param format
	 * @return
	 */
	public String getStartOfMonth(int num, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到当月的第一天
	 * @param format
	 * @return
	 */
	public String getStartOfMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到当月的第一天
	 * @param format
	 * @return
	 */
	public String getStartOfMonth_test(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到下一月的第一天
	 * @param format
	 * @return
	 */
	public String getStartOfNextMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 加一年
	 * @return
	 */
	public String getYears() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(1, +1);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 加半年
	 * @return
	 */
	public String getHalfYear() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(2, +6);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 加一个季度
	 * @return
	 */
	public String getQuarters() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(2, +3);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 返回yyyy-MM-dd格式的字符串
	 * @return
	 */
	public static String getLocalDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		return df.format(gc.getTime());
	}
	

	/**
	 * 日期转换("yyyy-MM-dd")
	 */
	public static final Date parseDate(String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期转换("yyyy-MM-dd")
	 */
	public static final Date parseDate(String dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回yyyy-MM-dd格式的字符串
	 * @return
	 */
	public static String getparseDate(Date dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateStr);
		return df.format(cal.getTime());
	}
	
	
	/**
	 * 按照概率生成对应的随机数 <br>
	 * 例如: int[] arr = {70, 20, 10} 生成的随机数:0(概率为70%) 生成的随机数:1(概率为20%)
	 * 生成的随机数:2(概率为10%)
	 * @param arr
	 * @return i 返回下标: 0,1,2 ...
	 */
	public static int weightRandom(Integer[] arr) {
		int x = (int) (Math.random() * 100);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > x) {
				return i;
			}
		}
		return -1;
	}

	/****
	 * 验证 Integer类型
	 * @param i
	 * @return
	 */
	public static boolean isBlank(Integer i) {
		if (i == null) {
			return true;
		}
		return false;
	}

	public static BigDecimal doubleToBigDecimal(Double d) {
		try {
			return new BigDecimal(d.toString());
		} catch (Exception e) {
			return new BigDecimal("0");
		}
	}

	/***
	 * l == null || l.size() <= 0 返回 true
	 * @param l
	 * @return
	 */
	public static boolean isEmptyList(List<?> l) {
		if (l == null || l.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 提供精确的加法运算。
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.add(b2)).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.subtract(b2)).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.multiply(b2)).doubleValue();
	}


	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			System.err.println("除法精度必须大于0!");
			return 0;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}

	/***
	 * 获得当前时间和传入时间相隔的秒数
	 * */
	public static long getSpacing(Date date1) {
		Date date = new Date();
		return (date.getTime() - date1.getTime()) / 1000;
	}

	/**
	 * 整理数据Double的小数位数
	 * */
	public static double getDoubleByScale(Double v1, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		return b1.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/****
	 * 获取指定日期 minute分钟后的时间
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date getTimeAfterMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minute);
		return c.getTime();
	}

	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/***
	 * 判断是否是英文
	 * @param strName
	 */
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length;) {
			char c = ch[i];
			if (isChinese(c) == true) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * @param s
	 * @return
	 */
	public static String toUTF8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
	 * 要用到正则表达式
	 */

	public static String digitUppercase(double n) {

		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" },
		{ "", "拾", "佰", "仟" } };
		String head = n < 0 ? "负" : "";
		n = Math.abs(n);
		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(n);
		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
		}
		return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");

	}

	/**
	 * 获得配置文件所在目录<br>
	 * @param file
	 * @return
	 */
	public static File getResource(String file) {
		URL url = CommonUtils.class.getResource("");
		String pkg = "";
		if (CommonUtils.class.getPackage() != null) {
			pkg = CommonUtils.class.getPackage().getName();
		}
		String path = url.getPath();
		path = path.substring(0, path.length() - pkg.length() - 1);
		String fileSeparator = System.getProperty("link.properties");
		File rtn = new File(path + fileSeparator + file.trim());
		return rtn;
	}

	public static String getMacAddr() {
		String MacAddr = "";
		try {
			Enumeration<NetworkInterface> em = NetworkInterface.getNetworkInterfaces();
			while (em.hasMoreElements()) {
				NetworkInterface nic = em.nextElement();
				byte[] b = nic.getHardwareAddress();
				if (b == null) {
					continue;
				}
				for (int i = 0; i < b.length; i++) {
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return MacAddr;
	}

	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				Enumeration<?> e2 = ni.getInetAddresses();
				while (e2.hasMoreElements()) {
					InetAddress ia = (InetAddress) e2.nextElement();
					ip = ia.getHostAddress();
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return ip;
	}

	/* 一个将字节转化为十六进制ASSIC码的函数 */
	public static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	/****
	 * 获取数组值
	 * @param array
	 * @param index
	 * @return
	 */
	public static String getArrayValue(String[] array, int index) {
		try {
			return array[index];
		} catch (Exception e) {
			return "";
		}
	}

	public static String md5ByHex(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte b[] = src.getBytes();
			md.reset();
			md.update(b);
			byte hash[] = md.digest();
			String hs = "";
			String stmp = "";
			for (int i = 0; i < hash.length; i++) {
				stmp = Integer.toHexString(hash[i] & 0xff);
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else
					hs = hs + stmp;
			}

			return hs.toUpperCase();
		} catch (Exception e) {
			return "";
		}
	}

	public static long strToLong(String str) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return 0L;
		}
	}

	public static String UrlDecode(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	// 保持长度 替换最后一个元素
	public static String[] repArray(String[] array, String newStr, int len) {

		if (array == null || array.length <= 0) {
			return new String[] { newStr };
		}
		List<String> list = new ArrayList<String>();
		list.add(newStr);
		for (int i = 0; i < array.length; i++) {
			if (list.size() >= len) {
				break;
			}
			if (!array[i].equals(newStr)) {
				list.add(array[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	public static String[] repArrayStr(String[] array) {
		if (array == null || array.length <= 0) {
			return array;
		} else {
			for (int i = 0; i < array.length; i++) {
				array[0] = array[0].split("_")[0];
			}
			return array;
		}
	}



	/****
	 * 数组分页
	 * @param strs
	 *            数组集合（ids）
	 * @param pageSize
	 *            每页显示数
	 * @param toPage
	 *            当前页
	 * @param order
	 *            排序 0 asc 1 desc
	 * @return
	 */
	public static String[] getArray(String[] strs, int pageSize, int toPage, int order) {
		if (strs == null) {
			return new String[] {};
		}

		if (order == 1) {
			strs = arraySort(strs);
		}
		int start = 0;
		int end = 0;
		end = toPage * pageSize;
		if (end >= strs.length) {
			end = strs.length - start;
		}
		start = (toPage - 1) * pageSize;
		if (start > strs.length) {
			return new String[] {};
		}
		String[] ns = new String[(end - start)];
		System.arraycopy(strs, start, ns, 0, (end - start));
		return ns;
	}

	/***
	 * 数组倒序
	 * @param strs
	 * @return
	 */
	public static String[] arraySort(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return new String[] {};
		}
		String[] newstr = new String[strs.length];
		int len = 0;
		for (int i = strs.length - 1; i >= 0; i--) {
			newstr[len] = strs[i];
			len++;
		}
		return newstr;
	}
	
	/**
     *  是否是数字
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false; 
        int start = (chars[0] == '-') ? 1 : 0;
        if (sz > start + 1) {
            if (chars[start] == '0' && chars[start + 1] == 'x') {
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                } 
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                        && (chars[i] < 'a' || chars[i] > 'f')
                        && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--;  
        int i = start; 
        while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) { 
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') { 
                if (hasExp) { 
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false;  
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') { 
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') { 
                return false;
            }
            if (!allowSigns  && (chars[i] == 'd' || chars[i] == 'D'  || chars[i] == 'f'  || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l' || chars[i] == 'L') { 
                return foundDigit && !hasExp;
            } 
            return false;
        } 
        return !allowSigns && foundDigit;
    }
    
    /**差集*/
    public static Set<String> difference(Set<String> setA, Set<String> setB) {
        Set<String> setDifference = new HashSet<String>();
        String s = "";
        Iterator<String> iterA = setA.iterator();
        while (iterA.hasNext()) {
            s = iterA.next();
            if(!setB.contains(s)) {
                setDifference.add(s);
            }
        }
        return setDifference;
    }
    
    public static String[] sort(String[] list){
    	for(int i=0;i<list.length-1;i++) {
    		   for(int j=1;j<list.length-i;j++) {
    		    Integer a;
    		    if((Integer.valueOf(list[j-1].trim())).compareTo(Integer.valueOf(list[j].trim()))>0) {   //比较两个整数的大小
    		     a=Integer.valueOf(list[j-1].trim());
    		     list[j-1]=list[j].trim(); 
    		     list[j]=a.toString();
    		    }
    		   }
    		  }
		return list;
    }
    /**
     * left-right的秒数
     * @author 彭堃(penkee@163.com), 2013-10-11
     *
     */
    public static long calDateSecondVariation(Date left,Date right){
    	long diff = left.getTime() - right.getTime();
    	return diff/1000;
    }
    
    /**
	 * 返回小数点后2位
	 * @param object
	 * @return .00
	 */
	public static BigDecimal setScaleBidDecimal(BigDecimal bd){
	    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);   // 取小数点后2位   /ROUND_HALF_UP
	    return bd;
	}
	 /**
	    * 汉字转拼音的方法
	    * @param name 汉字
	    * @return 拼音
	    *//*
	    public static String getHanyuToPinyin(String name){
	    	String pinyinName = "";
	        char[] nameChar = name.toCharArray();
	        HanyuPinyinOutputFormat defaultFormat = 
	                                           new HanyuPinyinOutputFormat();
	        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	        for (int i = 0; i < nameChar.length; i++) {
	            if (nameChar[i] > 128) {
	                try {
	                    pinyinName += PinyinHelper.toHanyuPinyinStringArray
	                                           (nameChar[i], defaultFormat)[0];
	                } catch (BadHanyuPinyinOutputFormatCombination e) {
	                    e.printStackTrace();
	                }
	            } 
	        }
	        return pinyinName;
	    }*/
	    /**
	     * 随机返回一个小写字母
	     * @author liuy
	     *  @return
	     * @return String
	     * @date 2014-3-10 下午5:58:52
	     */
		public static String getRecoNamemcod(){
			//
//			MassegeUtil.setLength(4);
			String name = "";
			Map<String, Object> param = new HashMap<String, Object>();
			String[] beforeShuffle = new String[] {
					"a", "b", "c", "d", "e", "f", "g", "h", "j",  
					"k", "l", "m", "n", "p", "q", "r", "s", "t", "u", "v",  
					"w", "x", "y", "z" }; 
			Random rd = new Random();
			name = beforeShuffle[rd.nextInt(24)];  //字母
			return name;
		}
		
		/**
		 * 返回4个随机数
		 * @author liuy
		 *  @return
		 * @return String
		 * @date 2014-3-10 下午5:58:06
		 */
		public static String getRandomNumber(){
			StringBuilder randnum= new StringBuilder();//验证码
//			String[] c=new String[]{"2","3","4","5","6","7","8","9","6","8"};
			for(int i=0;i<4;i++){
				Random rd = new Random();
				int index = rd.nextInt(10);
					do{
						index = rd.nextInt(10);
					}while(index==0||index==1);
				randnum.append(index);
			}
			return randnum.toString();
		}
		/**
		 * 判断是否为汉子
		 * @author liuy
		 *  @return
		 * @return boolean
		 * @date 2014-3-10 下午6:36:51
		 */
		public static boolean getPatternHanzi(String str){
			Pattern p_str = Pattern.compile("[\\u4e00-\\u9fa5]+");
//			String str="xzzc我是汉字";
			Matcher m = p_str.matcher(str);
			if(m.find()&&m.group(0).equals(str)){
				//OK  是汉字
				return true;
			}
			return false;
			
		}
		/**
		 * @about chengy
		 * @param str
		 * @return
		 * @date 2014-3-13 上午11:36:45
		 * 根据"$"符号切割字符串,返回一个字符串数组
		 */
		
		public static String[] subStringBY(String str){
			
			String []a=str.split("\\$");
			String[] strs=new String[a.length];
			for (int i = 0; i < a.length; i++) {
				strs[i]=a[i];
			}
			
			return  strs; 
		}
}
