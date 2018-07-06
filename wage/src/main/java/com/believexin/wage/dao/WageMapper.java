package com.believexin.wage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.believexin.wage.common.model.PageInfo;

/**
 * <p>Title: TAtyUserMapper</p>
 * <p>Description:  映射文件</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年3月12日 下午11:07:17
 */
@Mapper
public interface WageMapper {
	/**
	 * <p>Title: getRoles</p>
	 * <p>Description: 获取员工角色（职务）</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年3月28日 下午10:14:33
	 */
	List<Map<String,Object>> getRoles ();
	/**
	 * <p>Title: getUserAndSalary</p>
	 * <p>Description: 获取用户和工资信息（分页）</p>
	 * <p>Company: thunisoft </p> 
	 * @param pageInfo
	 * @return
	 * @author zhangxin
	 * @date 2018年4月8日 下午4:07:07
	 */
	List<Map<String, Object>> getUserAndSalaryForPage(PageInfo pageInfo);
	int getUserAndSalaryForPageSize();
	
	List<Map<String, Object>> getAvgWage(String roleid);
	List<Map<String, Object>> getAvgWageForUser(String userid);
}
