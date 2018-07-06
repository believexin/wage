package com.believexin.wage.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.believexin.wage.common.OrganType;
import com.believexin.wage.dao.CorpMapper;
import com.believexin.wage.dao.DeptMapper;
import com.believexin.wage.dao.UserMapper;

/**
 * <p>Title: CachesManager</p>
 * <p>Description: 管理缓存</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月6日 下午12:50:53
 */
@Component
public class InitCaches implements ApplicationRunner{
	
	@Autowired
	DeptMapper deptDao;
	@Autowired
	CorpMapper corpDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	OrganCache organCache;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		organCache.getOrgan(OrganType.Corps);
		organCache.getOrgan(OrganType.Depts);
		organCache.getOrgan(OrganType.Users);
	}
}
