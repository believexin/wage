package com.believexin.wage.common.model;

import java.util.List;

/**
 * <p>Title: RightsTree</p>
 * <p>Description: 权限树</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年5月2日 下午11:51:29
 */
public class RightsTree {
	private String id;
	private String label;
	private boolean disabled = false;
	
	public boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	private List<RightsTree> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<RightsTree> getChildren() {
		return children;
	}
	public void setChildren(List<RightsTree> children) {
		this.children = children;
	}
}
