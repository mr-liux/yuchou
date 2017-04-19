package com.youzi.yuchou.core.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.youzi.yuchou.core.reflect.ReflectionUtil;

/**
 * 
 *提取集合内元素的内容
 * 
 */
public class CollectionExtractor {

	/**
	 * 提取集合中的对象的两个属性(通过Getter函数), 组合成Map.
	 * 
	 * @param collection 来源集合.
	 * @param keyPropertyName 要提取为Map中的Key值的属性名.
	 * @param valuePropertyName 要提取为Map中的Value值的属性名.
	 */
	public static Map extractToMap(final Collection collection, final String keyPropertyName,
			final String valuePropertyName) {
		Map map = new HashMap(collection.size());

		try {
			for (Object obj : collection) {
				map.put(ReflectionUtil.getProperty(obj, keyPropertyName),
						ReflectionUtil.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtil.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

}
