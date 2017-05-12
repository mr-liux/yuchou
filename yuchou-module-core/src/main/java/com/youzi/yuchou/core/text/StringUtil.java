/*
 * Copyright 2011-2016 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.youzi.yuchou.core.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @Copyright @2016 STO All rights reserved.
 * 
 * @Description 各种操作字符串{@link String}的方法。
 * 
 * @author <a href="mailto:lichangwei@sto.cn">李长伟</a>
 *
 * @since 2016年1月12日 上午9:49:26
 */
public abstract class StringUtil {

	/**
	 * sl4j日志记录器
	 */
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	// ---------------------------------------------------------------------
	// 接入校验正则表达式
	// ---------------------------------------------------------------------

	/**
	 * 接入扫描时间校验正则表达式，格式形如："2015-7-22 18:58:25"
	 */
	private static final String REGEX_RECEIVE_OPTIME = "^\\d{4}-\\d{1,2}-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$";

	/**
	 * 接入数字校验正则表达式
	 */
	private static final String REGEX_RECEIVE_NUMERIC = "^\\d+$";

	/**
	 * 接入时间间隔秒数 2016-08-27
	 */
	private static final int times = 300 * 1000;// 300秒
	// ---------------------------------------------------------------------
	// 字符串工具基础方法
	// ---------------------------------------------------------------------

	/**
	 * 判断当前传入的字符串{@link String}是否为{@code null}，或者至少包含一个非空字符。
	 * <p>
	 * 
	 * <pre>
	 *         StringUtil.hasText(null) = false
	 *         StringUtil.hasText("") = false
	 *         StringUtil.hasText("   ") = false
	 *         StringUtil.hasText("123456") = true
	 *         StringUtil.hasText("1  2") = true
	 * </pre>
	 * </p>
	 * 
	 * @param str
	 *            需要校验的字符串
	 * @return 如果当前字符串不为{@code null}并且至少包含一个非空字符则返回{@code true}
	 * @see StringUtils#hasText(String)
	 */
	public static boolean hasText(String str) {
		return StringUtils.hasText(str);
	}

	/**
	 * 批量判断当前传入的字符串数组中的每一个元素是否为{@code null}或者并且至少包含一个非空字符。
	 * 
	 * @param strList
	 *            需要校验的字符串数组
	 * @return 返回一个结果的{@link List}集合，如果元素不为{@code null}并且至少包含一个非空字符则返回{@code true}，
	 * @see #hasText(String)
	 * @see ObjectUtils#isEmpty(Object[])
	 */
	public static List<Boolean> hasTextElement(String... strList) {
		if (ObjectUtils.isEmpty(strList)) {
			return null;
		}

		List<Boolean> resultList = new ArrayList<Boolean>();
		for (String str : strList) {
			resultList.add(hasText(str));
		}
		return resultList;
	}

	/**
	 * 判断当前传入的字符串是否为数字
	 * 
	 * @param str
	 *            需要校验的字符串
	 * @return 如果当前字符串非空，且为数字则返回{@code true}
	 */
	public static boolean isNumeric(String str) {
		if (!hasText(str)) {
			return false;
		}
		String regex = REGEX_RECEIVE_NUMERIC;

		return str.matches(regex);
	}

	/**
	 * 根据指定的模式解析日期字符串，当日期和模式为空{@code null}或者空白字符串时，
	 * 抛出{@link IllegalArgumentException}
	 * 
	 * @param date
	 *            需要解析的日期格式字符串
	 * @param pattern
	 *            与日期字符串匹配的模式
	 * @return 解析过后的日期类，如果日期格式字符串或者模式匹配字符串为空或者为{@code null}，则返回{@code null}
	 */
	public static Date parseDate(String date, String pattern) {
		if (!hasText(date) || !hasText(pattern) || !date.matches(REGEX_RECEIVE_OPTIME)) {
			return null;
		}

		DateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			logger.error("解析日期异常：{}", e.getMessage());
		}
		return null;
	}

	/**
	 * 比较两个日期的大小，如果原时间或者目标时间为null， 则抛出{@link NullPointerException}
	 * 
	 * @param source
	 *            需要比较的原时间
	 * @param target
	 *            需要比较的目的时间
	 * @return 如果原时间大于目的时间返回{@code 1}， 如果原时间小于目的时间返回{@code -1}，
	 *         如果原时间等于目的时间返回{@code 0}， 如果原时间或目的时间为null，则返回{@code null}
	 * 
	 */
	public static Integer compareToDate(Date source, Date target) {
		if (source == null || target == null) {
			return null;
		}

		long sourceTime = source.getTime() - times;
		long targetTime = target.getTime();
		return (sourceTime > targetTime ? 1 : sourceTime < targetTime ? -1 : 0);
	}

	/**
	 * 比较原时间是否在指定的日期时间范围内
	 * 
	 * @param source
	 *            原时间
	 * @param max
	 *            需要比较的最大时间
	 * @param min
	 *            需要比较的最小时间
	 * @return 返回{@code true}如果当前时间在max和min的时间范围内，包含等于。
	 */
	public static boolean betweenDate(Date source, Date max, Date min) {
		return (compareToDate(source, max) <= 0 && compareToDate(source, min) >= 0);
	}

	/**
	 * 向指定的日期上添加指定的时间，如果添加的值为负数，则为向后递减指定的时间
	 * 
	 * @param source
	 *            需要计算的日期
	 * @param field
	 *            添加的值的字段，例如日月年，时分秒等
	 * @param amount
	 *            需要递增或递减的时间
	 * @return 返回计算过后的日期
	 * @see Calendar#YEAR
	 * @see Calendar#MONTH
	 * @see Calendar#DATE
	 * @see Calendar#HOUR
	 * @see Calendar#MINUTE
	 * @see Calendar#SECOND
	 */
	public static Date addToDate(Date source, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.add(field, amount);
		return cal.getTime();
	}

	// ---------------------------------------------------------------------
	// 字符串工具接入封装方法
	// ---------------------------------------------------------------------

	/**
	 * 校验扫描时间是否为有效的时间， 首先时间必须符合"yyyy-MM-dd HH:mm:ss"格式，
	 * 其次扫描时间不能超过当前服务器时间，也不能小于当前时间一年之前
	 * 
	 * @param opTime
	 *            单条扫描记录的扫描时间
	 * @return 如果扫描时间符合以上规则，返回{@code true}，如果操作时间为null，则返回{@code false}
	 * @see #parseDate(String, String)
	 * @see #addToDate(Date, int, int)
	 * @see #betweenDate(Date, Date, Date)
	 */
	public static boolean validateOpTime(String opTime) {
		int len = opTime.length();
		String format = "yyyy-MM-dd HH:mm:ss";
		int size = format.length();// 标准格式长度
		if (len > size) {
			opTime = opTime.substring(0, size);// 只处理超出长度毫秒数
		}
		Date source = parseDate(opTime, format);
		Date now = new Date();
		Date minDate = addToDate(now, Calendar.YEAR, -1);

		if (source == null) {
			return false;
		}
		return betweenDate(source, now, minDate);
	}

	/**
	 * 校验当前字段的值必须为数字。
	 * 
	 * @param str
	 *            需要校验的字段的值
	 * @return 如果当前字段的值非空且是数字则返回{@code true}
	 * @see #isNumeric(String)
	 */
	public static boolean validateNumericField(String str) {
		return isNumeric(str);
	}

	/**
	 * 校验当前字段的值必须为数字且长度等于指定的长度。
	 * 
	 * @param str
	 *            需要校验的字段的值
	 * @param length
	 *            指定当前字段值的长度
	 * @return 如果当前字段的值非空且是数字，而且长度等于指定的长度则返回{@code true}
	 * @see #isNumeric(String)
	 */
	public static boolean validateNumericField(String str, int length) {
		if (length > 0) {
			return isNumeric(str) && str.length() == length;
		}
		return false;
	}

	/**
	 * 校验当前字段的值必须为非空的字符串。
	 * 
	 * @param str
	 *            需要校验的字段的值
	 * @return 如果当前字段的值非空
	 * @see #hasText(String)
	 */
	public static boolean validateStringField(String str) {
		return hasText(str);
	}

	/**
	 * 校验多个字段的值是否非空
	 * 
	 * @param strs
	 *            需要校验的多个字段的值
	 * @return 返回长度为字段个数的{@link Boolean}的list，值为{@code true}如果当前字段非空
	 * @see #hasTextElement(String...)
	 */
	public static List<Boolean> validateStringFields(String... strs) {
		return hasTextElement(strs);
	}

	/**
	 * 获取x分钟之前或者之后的的时间
	 * 
	 * @param minute
	 *            分钟数，之前用负数，之后用正数
	 * @param format
	 *            时间格式,不指定则默认"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String getForwardTimeByMinute(int minute, String format) {
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minute);
		return new SimpleDateFormat(format).format(cal.getTime());
	}

	/**
	 * 
	 * @Title: getForwardTimeByMinute
	 * @Description: 获取指定值之前或者之后的的时间
	 * @param @param
	 *            field Calendar类
	 * @param @param
	 *            num 数值，过去时间用负数，未来时间用正数
	 * @param @param
	 *            format 时间格式,不指定则默认"yyyy-MM-dd HH:mm:ss"
	 * @param @return
	 *            参数
	 * @return String 返回类型
	 */
	public static String getForwardTimeByMinute(int field, int num, String format) {
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		cal.add(field, num);
		return new SimpleDateFormat(format).format(cal.getTime());
	}

	/**
	 * 数组转字符以","分隔
	 * 
	 * @param o
	 * @return
	 */
	public static String arrayToStr(String[] o) {
		String str = "";
		if (o == null || o.length < 1)
			return "";
		for (String s : o)
			str += s + ",";
		return str.substring(0, str.length() - 1);
	}

	/**
	 * list转String, ","分隔
	 * 
	 * @param list
	 * @return
	 */
	public static String listToString(List<String> list) {
		StringBuffer sb = new StringBuffer();
		if (list == null || list.size() < 1)
			return "";
		for (String s : list) {
			sb.append(s);
			sb.append(",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	/**
	 * 字符转日期
	 * 
	 * @param date
	 *            日期格式的字符(2016/9/1)
	 * @return
	 * @throws ParseException
	 */
	public static String dateToString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String str = format.format(d);
		return str;
	}

	/**
	 * 日期格式字符串转换成时间戳(13位)
	 * 
	 * @param date
	 *            字符串日期
	 * @param format
	 *            如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long dateToTimeStamp(String date_str, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(date_str).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}

	/**
	 * 
	 * @Title: listToStr
	 * @Description: list转字符串，格式: name,sex,age
	 * @param @param
	 *            list
	 * @param @return
	 *            参数
	 * @return String 返回类型
	 */
	public static String listToStr(List<String> list) {
		if (list == null || list.size() < 1) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String str : list) {
			sb.append(str);
			sb.append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 
	 * @Title: isNumber
	 * @Description: TODO(是否为正整数或者小数)
	 * @param: @param
	 *             str
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isNumber(String str) {
		// 正整数
		Pattern pattern = Pattern.compile("^[0-9]\\d*$");
		if (pattern.matcher(str).matches()) {
			return true;
		}
		// 正小数
		pattern = Pattern.compile("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
		if (pattern.matcher(str).matches()) {
			return true;
		}
		return false;
	}
	
	public static Integer stringToInt(String str){
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	public static Integer stringToInt(String str,int defaultVal){
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

}
