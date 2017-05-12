
package com.youzi.yuchou.admin.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.AdMapper;
import com.youzi.yuchou.module.model.model.Ad;
import com.youzi.yuchou.module.mvc.common.StaticCode;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.utils.CommonUtils;

/**
 * 广告表
 * @author 背包  作者QQ：763542022
 * @date 创建时间：2017年5月10日 下午12:16:31
 */
@Service
public class AdService extends AdminBaseService {

	@Autowired
	private AdMapper adMapper;
	
	/**
	 * 添加
	 * @author 背包
	 * @param bank
	 */
	@Transactional
	public boolean add(Ad ad) {
		
		//获取信息封装
		
		int result = adMapper.insert(ad);
		return (result == 1);
	}
	/**
	 * 修改
	 * @author 背包
	 * @param bank
	 */
	@Transactional
	public boolean update(Ad ad) {
		//user_ky
		//add_time
		int result = adMapper.updateByPrimaryKey(ad);
		return (result == 1);
	}
	/**
	 * 删除状态为0
	 * @author 背包
	 * @param bank
	 */
	@Transactional
	public boolean updDelete(Integer id) {
		Ad ad = new Ad();
		ad.setAdId(id);
		ad.setStatus(StaticCode.SUCCESS);
		//修改用户ID，外键   upd_user_ky
		int result = adMapper.updateByPrimaryKeySelective(ad);
		return (result == 1);
	}
	/**
	 * 修改状态   //状态（0删除，1待发布，2已发布）
	 * @author 背包
	 * @param bank
	 */
	@Transactional
	public RestResponse<Object> updStatus(Ad ad) {
		RestResponse<Object> page=new RestResponse<Object>(); 
		if (CommonUtils.isObjectNotEmpty(ad.getAdId())) {
			//修改用户ID，外键   upd_user_ky
			int result = adMapper.updateByPrimaryKeySelective(ad);
			page.setSuccess(true);
			page.setCode(StaticCode.SUCCESS);
			page.setMessage("成功");
		}else{
			page.setSuccess(false);
			page.setCode(100);
			page.setMessage("ID不能为空");
		}
		return page; 
	}
	/**
	 * 根据主键查询
	 * @author 背包
	 * @param bank
	 */
	public RestResponse<Object> findById(Integer id) {
		Ad ad = adMapper.selectByPrimaryKey(id);
		RestResponse<Object> page=new RestResponse<Object>(); 
		page.setSuccess(true);
		page.setCode(StaticCode.SUCCESS);
		page.setData(ad);
		return page;
	}
	/**
	 * 分页查询
	 * @author 背包
	 */
	public RestResponse<Object> findPage(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<Ad> list = null;
		int totalCount = adMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = adMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setCode(StaticCode.SUCCESS);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}
	
}
