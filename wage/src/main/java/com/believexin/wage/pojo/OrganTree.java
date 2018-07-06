package com.believexin.wage.pojo;

import java.util.List;

import com.believexin.wage.common.OrganType;

/**
 * <p>Title: OrganTree</p>
 * <p>Description: 组织机构树</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月6日 下午12:12:32
 */
public class OrganTree {

	private String id;
	private String label;
	private OrganType organType;
	private Object content;
	private List<OrganTree> children;
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
	public OrganType getOrganType() {
		return organType;
	}
	public void setOrganType(OrganType organType) {
		this.organType = organType;
	}
	public List<OrganTree> getChildren() {
		return children;
	}
	public void setChildren(List<OrganTree> children) {
		this.children = children;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrganTree [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", organType=");
		builder.append(organType);
		builder.append(", content=");
		builder.append(content);
		builder.append(", children=");
		builder.append(children);
		builder.append("]");
		return builder.toString();
	}
}
