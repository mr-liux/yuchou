package com.youzi.yuchou.admin.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzi.yuchou.admin.service.common.AdminBaseService;
import com.youzi.yuchou.module.model.mapper.SysCompanyMapper;
import com.youzi.yuchou.module.model.model.SysCompany;
import com.youzi.yuchou.module.mvc.dto.RestResponse;
import com.youzi.yuchou.module.mvc.dto.TreeNode;
import com.youzi.yuchou.module.mvc.form.PageInfo;
import com.youzi.yuchou.module.mvc.utils.TreeNodeUtil;

@Service
public class SysCompanyService extends AdminBaseService  {
	@Autowired
	private SysCompanyMapper  companyMapper;
	@Autowired
	private TreeNodeUtil treeNodeUtil;
	
	public boolean add(SysCompany company) {
		if(companyMapper.insert(company)>0){
			return true;
		}
		return false;
	}

	public boolean delete(Integer id) {
		if(companyMapper.updateByStatus(id)>0){
			return true;
		}
		return false;
	}

	public boolean update(SysCompany company) {
		if(companyMapper.updateByPrimaryKey(company)>0){
			return true;
		}
		return false;
	}

	public SysCompany findById(Integer id) {
		return companyMapper.selectByPrimaryKey(id);
	}
	
	public RestResponse<Object> findAll(PageInfo pageInfo) {
		RestResponse<Object> page = new RestResponse<Object>();
		List<SysCompany> list = null;
		int totalCount = companyMapper.count(pageInfo.getParamsMap());
		if(totalCount>0){
			list = companyMapper.query(pageInfo.getParamsMap());
		}
		pageInfo.setTotalCount(totalCount);
		page.setSuccess(true);
		page.setData(list);
		page.addExtData("pageInfo", pageInfo);
		return page;
	}
	
	
	
	public List<TreeNode> getTreeNode(PageInfo pageInfo) {
		List<SysCompany> list = null;
		int totalCount = companyMapper.count(pageInfo.getParamsMap());
		List<TreeNode> treeNode= null;
		if(totalCount>0){
			list = companyMapper.query(pageInfo.getParamsMap());
			List<TreeNode> rootNodeList = new ArrayList<TreeNode>();
			List<TreeNode> childNodeList = new ArrayList<TreeNode>();
			List<SysCompany> newList=new ArrayList<SysCompany>(list);
			for (SysCompany sysCompany : list) {
				this.checkIsParent(sysCompany, newList);
				TreeNode node = new TreeNode();
				node.setId(sysCompany.getCompanyKy());
				node.setPid(sysCompany.getPid());
				node.setText(sysCompany.getName());
				node.setParent(sysCompany.getParent());
				if(sysCompany.getPid()==0){
					rootNodeList.add(node);
				}else{
					childNodeList.add(node);
				}
			}
			treeNodeUtil.setRootNodeList(rootNodeList);
			treeNodeUtil.setChildNodeList(childNodeList);
			treeNode = treeNodeUtil.getTreeNodes();
		}
		return treeNode;
	}
	
	
	/**
	 * 验证单个对象是否是父节点
	 * @param company
	 * @param list
	 */
	private void checkIsParent(SysCompany company,List<SysCompany> list){
		for (SysCompany sysCompany : list) {
			if(sysCompany.getPid() ==company.getCompanyKy()){
				company.setParent(true);
				break;
			}
		}
	}




}
