package com.believexin.wage.common;

/**
 * <p>Title: OrganType</p>
 * <p>Description: 组织机构类型</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月6日 下午12:16:13
 */
public enum OrganType {
	Users("user","用户"),
	Depts("dept","部门"),
	Corps("corp","单位");
	
	/**
	 * 组织机构-代码
	 */
	private String organCode;
	/**
	 * 组织机构-描述
	 */
	private String organDescribe;
	private OrganType(String organCode, String organDescribe) {
		this.organCode = organCode;
		this.organDescribe = organDescribe;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrganDescribe() {
		return organDescribe;
	}
	public void setOrganDescribe(String organDescribe) {
		this.organDescribe = organDescribe;
	}
}
