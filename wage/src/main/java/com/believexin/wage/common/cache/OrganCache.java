package com.believexin.wage.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.believexin.wage.common.OrganType;
import com.believexin.wage.dao.CorpMapper;
import com.believexin.wage.dao.DeptMapper;
import com.believexin.wage.dao.UserMapper;
import com.believexin.wage.pojo.Corp;
import com.believexin.wage.pojo.Dept;
import com.believexin.wage.pojo.User;

/**
 * <p>Title: CorpsCache</p>
 * <p>Description: 组织机构缓存</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月6日 下午12:26:25
 */
@Component
public class OrganCache {
	@Autowired
	DeptMapper deptDao;
	@Autowired
	CorpMapper corpDao;
	@Autowired
	UserMapper userDao;
	
	/**
	 * <p>Title: getCorps</p>
	 * <p>Description: 组织机构缓存</p>
	 * <p>Company: thunisoft </p> 
	 * @param corpid
	 * @return
	 * @author zhangxin
	 * @date 2018年4月6日 下午12:45:30
	 */
	@Cacheable(value = "organ" , key = "#organType.organCode")
	public Map<String, Object> getOrgan(OrganType organType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(OrganType.Corps == organType) {
			List<Corp> corps = corpDao.query();
			for (Corp corp : corps) {
				map.put(corp.getcId(), corp);
			}
		}
		if(OrganType.Depts == organType) {
			List<Dept> depts = deptDao.query();
			for (Dept dept : depts) {
				map.put(dept.getcId(), dept);
			}
		}
		if(OrganType.Users == organType) {
			List<User> users = userDao.query();
			for (User user : users) {
				map.put(user.getcId(), user);
			}
		}
		return  map;
	}
}
