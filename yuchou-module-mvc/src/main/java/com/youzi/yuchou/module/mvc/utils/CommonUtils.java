
package com.youzi.yuchou.module.mvc.utils;

import java.math.BigDecimal;
import java.util.Date;


public class CommonUtils {

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
}
