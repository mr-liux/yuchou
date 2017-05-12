package com.youzi.yuchou.module.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	private int id;  
	// 父节点ID
	private int pid;
	
	private String text;
	// 是否展开
	private boolean open = false;
	// 是否是父节点
	private boolean isParent;
	// 是否是根节点
	private boolean isRoot = false;
	// 是否默认选中
	private boolean checked;
	// 访问的URL
	private String url;
	
	private List<TreeNode> children;
	
	
	public List<TreeNode> getChildren() {
		return children==null?new ArrayList<TreeNode>():children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getUrl() {
		if(url == null){
			url = "";
		}
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TreeNode(int id, int pid, String text, boolean open,
			boolean isParent, boolean isRoot, boolean checked, String url) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.open = open;
		this.isParent = isParent;
		this.isRoot = isRoot;
		this.checked = checked;
		this.url = url;
	}
	public TreeNode() {
		super();
	}
	
	
 }		
