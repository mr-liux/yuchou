package com.youzi.yuchou.module.mvc.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static final String EMPTY_STRING = "";
	public static final BigDecimal DEFAULT_BD = BigDecimal.ZERO;

	public static boolean isNullOrEmpty(String... strings) {
		for (String string : strings) {
			if (string == null || string.trim().equals(EMPTY_STRING)) {
				return true;
			}
		}
		return false;
	}

	public static String trimLeft(String source, String strtrim) {
		if (isNull(strtrim) || isNull(source))
			return source;

		if (source.length() < strtrim.length())
			return source;

		String tmp = source.substring(0, strtrim.length());

		if (tmp.equals(strtrim))
			return source.substring(strtrim.length());

		return source;
	}

	public static String format(Object obj) {
		if (null == obj)
			return EMPTY_STRING;
		return obj.toString();
	}

	public static boolean isNull(String str) {
		return null == str || str.length() == 0;
	}

	public static String formatWebString(String str) {
		if (null == str || "".equals(str) || "null".equals(str)) {
			return "&nbsp;";
		} else {
			return str;
		}
	}

	public static String formatWebString(Object obj) {
		return formatWebString(format(obj));
	}

	public static String formatWebStringByCut(Object obj, int lastCutIndex) {
		if (null == obj) {
			return "&nbsp;";
		}
		String s = format(obj);
		if (lastCutIndex > s.length()) {
			return s;
		} else {
			return s.substring(0, lastCutIndex);
		}
	}

	/*
	 * 截取指定长度的字符串，其他位数统一设置成*
	 */
	public static String hideStr(String s, int len) {
		if (null == s || s.length() == 0)
			return EMPTY_STRING;

		if (s.length() <= len) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, len));
		int length = s.length() - len;
		for (int index = 0; index < length; index++)
			sb.append('*');

		return sb.toString();
	}

	/*
	 * 截取指定长度的字符串，并以"..."结尾
	 */
	public static String subStr(String s, int len) {
		if (s.length() <= len) {
			return s;
		}
		return s.substring(0, len) + "...";
	}

	/*
	 * 截取指定长度的字符串
	 */
	public static String puresubStr(String s, int len) {
		if (null == s || s.length() <= len)
			return s;

		return html2Text(s.substring(0, len));
	}

	public static String subString(Object obj, int endIndex) {
		return subString(format(obj), endIndex);
	}

	public static String subStringWithoutDot(Object obj, int endIndex) {
		return subStringWithoutDot(format(obj), endIndex);
	}

	public static short stringToShort(String s) {
		try {
			return Short.parseShort(format(s));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int stringToInt(String s) {
		try {
			return Integer.parseInt(format(s));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static long stringToLong(String s) {
		try {
			return Long.parseLong(format(s));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int stringToInt(String s, int radix) {
		try {
			return Integer.parseInt(format(s), radix);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static double stringToDouble(String s) {
		try {
			return Double.parseDouble(format(s));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static BigDecimal stringToBigDecimal(String s) {
		try {
			return new BigDecimal(format(s));
		} catch (NumberFormatException e) {
			return DEFAULT_BD;
		}
	}

	public static BigDecimal[] stringsToBigDecimals(String[] arrs) {
		if (arrs == null || arrs.length == 0)
			return null;
		BigDecimal[] rets = new BigDecimal[arrs.length];
		for (int index = 0; index < arrs.length; index++) {
			rets[index] = stringToBigDecimal(arrs[index]);
		}
		return rets;
	}

	public static float stringToFloat(String s) {
		try {
			return Float.parseFloat(format(s));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean stringToBoolean(String s) {
		if ("true".equalsIgnoreCase(format(s)) || "1".equalsIgnoreCase(s))
			return true;
		return false;
	}

	public static boolean stringToBoolean(int i) {
		return i >= 1 ? true : false;
	}

	public static String stringFormatForHtml(String string) {
		if (string != null && !"".equals(string.trim())) {
			if (string.indexOf("\"") > -1) {
				string = string.replaceAll("\\\"", "&quot;");
			}
			if (string.indexOf("<") > -1) {
				string = string.replaceAll("\\<", "&lt;");
			}
			if (string.indexOf(">") > -1) {
				string = string.replaceAll("\\>", "&gt;");
			}
		}

		return string;
	}

	public static String padding(String str, int length) {
		if (isNull(str)) {
			return "00000";
		}
		if (str.length() >= length) {
			return str;
		}
		;
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length - str.length(); i++)
			sb.append('0');
		sb.append(str);
		return sb.toString();
	}

	public static String replace(String s, char oldSub, char newSub) {
		return replace(s, oldSub, new Character(newSub).toString());
	}

	public static String replace(String s, char oldSub, String newSub) {
		if ((s == null) || (newSub == null)) {
			return null;
		}

		StringBuffer sm = new StringBuffer();

		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == oldSub) {
				sm.append(newSub);
			} else {
				sm.append(c[i]);
			}
		}

		return sm.toString();
	}

	public static String replace(String s, String oldSub, String newSub) {
		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub);

		if (y >= 0) {
			StringBuffer sm = new StringBuffer();

			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sm.append(s.substring(x, y));
				sm.append(newSub);
				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sm.append(s.substring(x));

			return sm.toString();
		} else {
			return s;
		}
	}

	public static String replace(String s, String[] oldSubs, String[] newSubs) {
		if ((s == null) || (oldSubs == null) || (newSubs == null)) {
			return null;
		}

		if (oldSubs.length != newSubs.length) {
			return s;
		}

		for (int i = 0; i < oldSubs.length; i++) {
			s = replace(s, oldSubs[i], newSubs[i]);
		}

		return s;
	}

	public static String listToString(List<String> strList) {
		if (null == strList || strList.size() == 0)
			return EMPTY_STRING;
		StringBuilder sb = new StringBuilder();
		for (String str : strList) {
			if (sb.length() != 0) {
				sb.append(",");
			}
			sb.append(str);
		}
		return sb.toString();
	}

	public static String decimallistToString(List<BigDecimal> idList) {
		if (null == idList || idList.size() == 0)
			return EMPTY_STRING;
		StringBuilder sb = new StringBuilder();
		for (BigDecimal id : idList) {
			if (sb.length() != 0) {
				sb.append(",");
			}
			sb.append(id.toPlainString());
		}
		return sb.toString();
	}

	public static String[] stringToArray(String str) {
		if (isNull(str))
			return new String[] {};
		return str.split(",");
	}

	public static boolean contains(String[] arr, String str) {
		if (null == arr || arr.length == 0 || isNull(str))
			return false;
		for (String s : arr) {
			if (str.equals(s))
				return true;
		}
		return false;
	}

	public static String[] restoreString(String str, String sep) {
		if (StringUtil.isNull(str))
			return new String[0];
		List<String> ls = new ArrayList<String>();
		String temp = str;
		int index = 0;
		while (temp.length() > 0) {
			index = temp.indexOf(sep);
			if (index == -1) {
				ls.add(temp);
				break;
			}
			ls.add(temp.substring(0, index));
			temp = temp.substring(index + sep.length());
		}
		String[] arr = new String[ls.size()];
		return ls.toArray(arr);
	}

	/*
	 * 过滤html标签函数
	 */
	public static String html2Text(String inputString) {
		if (null == inputString || inputString.length() == 0)
			return inputString;

		String htmlStr = inputString; // 含html标签的字符串
		String textStr = EMPTY_STRING;
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(EMPTY_STRING); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(EMPTY_STRING); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(EMPTY_STRING); // 过滤html标签

			textStr = htmlStr;
		} catch (Exception e) {
		}

		return textStr;// 返回文本字符串
	}

	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}

	public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

		if (str == null) {
			return null;
		}
		StringTokenizer st = new StringTokenizer(str, delimiters);
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}
		return toStringArray(tokens);
	}

	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new String[collection.size()]);
	}

	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static int countOccurrencesOf(String str, String sub) {
		if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
			return 0;
		}
		int count = 0;
		int pos = 0;
		int idx;
		while ((idx = str.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}

	public static String[] splitStringByLen(String source, int length, int maxnum) {
		if (maxnum < 1 || length < 1 || StringUtil.isNull(source))
			return new String[] {};

		String[] ret_arrs = new String[maxnum];
		int index = 0;
		for (index = 0; index < ret_arrs.length; index++)
			ret_arrs[index] = null;

		index = 0;
		while (source.length() > length) {
			if (index < maxnum) {
				ret_arrs[index] = source.substring(0, length);
				source = source.substring(length);
			} else
				break;
			index++;
		}

		if ((index < maxnum) && (source.length() > 0) && (source.length() <= length)) {
			ret_arrs[index] = source;
		}

		return ret_arrs;
	}
	
}