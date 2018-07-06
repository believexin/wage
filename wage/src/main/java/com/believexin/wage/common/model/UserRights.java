package com.believexin.wage.common.model;

import java.util.List;

/**
 * <p>Title: UserRights</p>
 * <p>Description: 人员权限</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年5月6日 下午4:13:06
 */
public class UserRights {
	/**
	 * 人员id
	 */
	private String userid;
	/**
	 * 权限字
	 */
	private List<String> rightKeys;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<String> getRightKeys() {
		return rightKeys;
	}
	public void setRightKeys(List<String> rightKeys) {
		this.rightKeys = rightKeys;
	}
}
