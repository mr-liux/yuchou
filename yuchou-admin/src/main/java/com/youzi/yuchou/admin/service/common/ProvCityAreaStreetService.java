
package com.youzi.yuchou.admin.service.common;

import com.youzi.yuchou.module.model.mapper.ProvCityAreaStreetMapper;
import com.youzi.yuchou.module.model.model.ProvCityAreaStreet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地区字典
 * @author 背包  作者QQ：763542022
 * @date 创建时间：2017年4月26日 下午4:03:34
 */
@Service
public class ProvCityAreaStreetService extends AdminBaseService {

	@Autowired
	private ProvCityAreaStreetMapper provCityAreaStreetMapper;

	/**
	 * 根据级别查询集合
	 * @author 背包
	 * @param level
	 */
	@Cacheable(value = "ProvCityAreaStreet_level", key = "#level")
	public List<ProvCityAreaStreet> getParamsList(int level) {
		return provCityAreaStreetMapper.getParamsList(level);
	}
	/**
	 * 根据code编号作为parentCode父编号的条件查询集合
	 * @author 背包
	 * @param code
	 */
	@Cacheable(value = "ProvCityAreaStreet_ParentCode", key = "#code")
	public List<ProvCityAreaStreet> getParentCodeList(int code) {
		return provCityAreaStreetMapper.getParentCodeList(code);
	}


	
}
