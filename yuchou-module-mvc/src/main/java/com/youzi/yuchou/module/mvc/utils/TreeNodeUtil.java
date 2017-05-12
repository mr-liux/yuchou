package com.youzi.yuchou.module.mvc.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.youzi.yuchou.module.mvc.dto.TreeNode;

/**
 * @author yicj
 * @see 解析树状菜单
 */
@Service
public class TreeNodeUtil {
	
	//存储根节点数据
	private List<TreeNode> rootNodeList;
	
	//存储普通节点数据
	private List<TreeNode> childNodeList;
	
	
	private List<TreeNode> rootList ;
	
	public List<TreeNode> getRootNodeList() {
		return rootNodeList;
	}

	public void setRootNodeList(List<TreeNode> rootNodeList) {
		this.rootNodeList = rootNodeList;
	}

	public List<TreeNode> getChildNodeList() {
		return childNodeList;
	}

	public void setChildNodeList(List<TreeNode> childNodeList) {
		this.childNodeList = childNodeList;
	}


	/**
	 * 获取多个根节点的treeNode集合
	 * @return
	 */
	public List<TreeNode> getTreeNodes(){
		rootList = new ArrayList<TreeNode>();
		for (TreeNode treeNode : rootNodeList) {
			rootList.add(getTreeNodeData(treeNode));
		}
		return rootList;
	}
	
	/**
	 * 获取单个根节点的TreeNode对象
	 * @param node
	 * @return
	 */
	public TreeNode getTreeNodeData(TreeNode node) {
		if(node == null){
			return null;
		}
		if(node.isParent()){
			int parentId = node.getId();
			if(parentId > 0){
				node.setChildren(getChildNodes(parentId));
			}
		}
		return node;
	}
	
	
	/**
	 * 根据父级节点获取所有子节点的json数据
	 * @param pid 父节点ID
	 * @return
	 */
	private List<TreeNode> getChildNodes(int pid) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (TreeNode node : childNodeList) {
			if(node == null){
				continue;
			}
			if (node.getPid() == pid) {
				nodes.add(getTreeNodeData(node));
			}
		}
		return nodes;
	}
	
	
	
	
}
