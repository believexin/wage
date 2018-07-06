package com.believexin.wage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.believexin.wage.common.CommonUtils;
import com.believexin.wage.common.OrganType;
import com.believexin.wage.common.cache.OrganCache;
import com.believexin.wage.common.model.PageInfo;
import com.believexin.wage.common.model.RightsTree;
import com.believexin.wage.common.model.UserRights;
import com.believexin.wage.dao.CorpMapper;
import com.believexin.wage.dao.DeptMapper;
import com.believexin.wage.dao.RightMapper;
import com.believexin.wage.dao.UserMapper;
import com.believexin.wage.dao.UserRightMapper;
import com.believexin.wage.dao.WageMapper;
import com.believexin.wage.pojo.Corp;
import com.believexin.wage.pojo.Dept;
import com.believexin.wage.pojo.OrganTree;
import com.believexin.wage.pojo.Right;
import com.believexin.wage.pojo.User;
import com.believexin.wage.pojo.UserRight;

@Service
public class WageService {

	@Autowired
	WageMapper wageMapper;
	@Autowired
	DeptMapper deptDao;
	@Autowired
	CorpMapper corpDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	OrganCache organCache;
	@Autowired
	RightMapper rightMapper;
	@Autowired
	UserRightMapper userRightMap;
	/**
	 * <p>Title: getRoles</p>
	 * <p>Description: 获取员工角色（职务）</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年3月28日 下午11:22:33
	 */
	public List<Map<String,Object>> getRoles(){
		return wageMapper.getRoles();
	}
	/**
	 * <p>Title: getOrganTree</p>
	 * <p>Description: 封装组织机构树</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年4月6日 下午12:18:53
	 */
	public List<OrganTree> getOrganTree(){
		List<OrganTree> resultTree = new ArrayList<OrganTree>();
		Map<String, Object> corps = organCache.getOrgan(OrganType.Corps);
		Set<String> corpKeys = corps.keySet();
		for (String corpKey : corpKeys) {
			Corp corp = (Corp)corps.get(corpKey);
			if(corp != null) {
				OrganTree corpsTree = new OrganTree();
				corpsTree.setId(corpKey);
				corpsTree.setLabel(corp.getcName());
				corpsTree.setContent(corp);
				corpsTree.setOrganType(OrganType.Corps);
				List<OrganTree> deptsTree = getDepts(corpKey);
				List<OrganTree> usersTree = getUsers(corpKey,true);
				if(!deptsTree.isEmpty() || !usersTree.isEmpty()) {
					deptsTree.addAll(usersTree);
					corpsTree.setChildren(deptsTree);
				}
				resultTree.add(corpsTree);
			}
		}
		return resultTree;
	}
	/**
	 * <p>Title: getDepts</p>
	 * <p>Description: 封装单位组织机构树</p>
	 * <p>Company: thunisoft </p> 
	 * @param corpid
	 * @return
	 * @author zhangxin
	 * @date 2018年4月7日 下午10:34:52
	 */
	public List<OrganTree> getDepts(String corpid){
		List<OrganTree> resultTree = new ArrayList<OrganTree>();
		Map<String, Object> depts = organCache.getOrgan(OrganType.Depts);
		Set<String> deptKeys = depts.keySet();
		for (String deptKey : deptKeys) {
			Dept dept = (Dept)depts.get(deptKey);
			if(dept != null && corpid.equals(dept.getcCorp())) {
				OrganTree deptsTree = new OrganTree();
				deptsTree.setId(deptKey);
				deptsTree.setLabel(dept.getcName());
				deptsTree.setOrganType(OrganType.Depts);
				deptsTree.setContent(dept);
				List<OrganTree> usersTree = getUsers(deptKey,false);
				if(usersTree != null && !usersTree.isEmpty()) {
					deptsTree.setChildren(usersTree);
				}
				resultTree.add(deptsTree);
			}
		}
		return resultTree;
	}
	/**
	 * <p>Title: getUsers</p>
	 * <p>Description: 封装用户组织机构树</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @return
	 * @author zhangxin
	 * @date 2018年4月7日 下午10:35:37
	 */
	public List<OrganTree> getUsers(String pid,boolean isCorp){
		List<OrganTree> resultTree = new ArrayList<OrganTree>();
		Map<String, Object> users = organCache.getOrgan(OrganType.Users);
		Set<String> userKeys = users.keySet();
		for (String userKey : userKeys) {
			User user = (User)users.get(userKey);
			if(isCorp && user != null && (user.getcDept() == null || user.getcDept().isEmpty()) && pid.equals(user.getcCorp())) {
				OrganTree usersTree = new OrganTree();
				usersTree.setId(userKey);
				usersTree.setLabel(user.getcName());
				usersTree.setOrganType(OrganType.Users);
				usersTree.setContent(user);
				resultTree.add(usersTree);
			}else if(user != null && pid.equals(user.getcDept())) {
				OrganTree usersTree = new OrganTree();
				usersTree.setId(userKey);
				usersTree.setLabel(user.getcName());
				usersTree.setOrganType(OrganType.Users);
				usersTree.setContent(user);
				resultTree.add(usersTree);
			}
		}
		return resultTree;
	}
	/**
	 * <p>Title: getUserSalaryInfo</p>
	 * <p>Description: 获取员工工资了列表</p>
	 * <p>Company: thunisoft </p> 
	 * @param pageInfo
	 * @return
	 * @author zhangxin
	 * @date 2018年4月8日 下午2:56:21
	 */
	public List<Map<String, Object>> getUserSalaryInfo(PageInfo pageInfo){
		return wageMapper.getUserAndSalaryForPage(pageInfo);
	}
	/**
	 * <p>Title: getUserAndSalaryForPageSize</p>
	 * <p>Description: 获取总数量</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年5月2日 下午10:48:54
	 */
	public int getUserAndSalaryForPageSize() {
		return wageMapper.getUserAndSalaryForPageSize();
	}
	/**
	 * <p>Title: loginServer</p>
	 * <p>Description: 登录验证</p>
	 * <p>Company: thunisoft </p> 
	 * @param loginid
	 * @param password
	 * @return
	 * @throws Exception
	 * @author zhangxin
	 * @date 2018年4月26日 下午11:21:07
	 */
	public boolean loginServer(String loginid,String password) throws Exception {
		User user = userDao.login(loginid);
		if(user == null) {
			throw new Exception("The user doesn't exist");
		}
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pwd = md5.encodePassword(password,"6789@jkl");
		if(pwd.equals(user.getcPassword())) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>Title: getAvgWage</p>
	 * <p>Description: </p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年5月2日 下午9:17:51
	 */
	public List<Map<String, Object>> getAvgWage(){
		List<Map<String, Object>> resultList = new ArrayList<>();
		List<Map<String, Object>> roles = wageMapper.getRoles();
		for (Map<String, Object> role : roles) {
			String roleid = role.get("role").toString();
			List<Double> avgWage = getAvgWageList(roleid);
			Map<String, Object> map = new HashMap<>();
			map.put("name",role.get("name").toString());
			map.put("type","line");
			map.put("data",avgWage);
			resultList.add(map);
		}
		return resultList;
	}
	/**
	 * <p>Title: getAvgWageList</p>
	 * <p>Description: </p>
	 * <p>Company: thunisoft </p> 
	 * @param roleid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月2日 下午9:17:55
	 */
	private List<Double> getAvgWageList(String roleid) {
		List<Double> list = new ArrayList<>();
		List<Map<String, Object>> avgWage = wageMapper.getAvgWage(roleid);
		for (Map<String, Object> map : avgWage) {
			list.add(Double.parseDouble(map.get("avg_salary").toString()));
		}
		return list;
	}
	
	public List<Double> getAvgWageForUser(String userid) {
		List<Double> list = new ArrayList<>();
		List<Map<String, Object>> avgWage = wageMapper.getAvgWageForUser(userid);
		for (Map<String, Object> map : avgWage) {
			list.add(Double.parseDouble(map.get("avg_salary").toString()));
		}
		return list;
	}
	/**
	 * <p>Title: getRights</p>
	 * <p>Description: 获取权限</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年5月3日 上午12:41:07
	 */
	public List<RightsTree> getRights(){
		List<Right> rightList = rightMapper.query();
		List<RightsTree> rightTree = new ArrayList<>();
		for (Right right : rightList) {
			String[] rights =  right.getcRightkey().split("\\.");
			if(rights.length == 1) {
				RightsTree temp = new RightsTree();
				temp.setId(right.getcRightkey());
				temp.setLabel(right.getcName());
				RightsTree tree = dealRightTree(rightList,right.getcRightkey(),0,temp);
				rightTree.add(tree);
			}
		}
		return rightTree;
	}
	private RightsTree dealRightTree(List<Right> rightList,String root,int level,RightsTree parentTree) {
		level ++;
		List<RightsTree> rightTree = new ArrayList<>();
		for (Right right : rightList) {
			String[] rights =  right.getcRightkey().split("\\.");
			if(rights.length == level + 1 && root.equals(rights[level - 1])) {
				RightsTree temp = new RightsTree();
				temp.setId(right.getcRightkey());
				temp.setLabel(right.getcName());
				RightsTree tree = dealRightTree(rightList,rights[level],level,temp);
				rightTree.add(tree);
			}
		}
		parentTree.setChildren(rightTree);
		return parentTree;
	}
	/**
	 * <p>Title: getUserNameByLoginid</p>
	 * <p>Description: 通过登录名获取用户姓名</p>
	 * <p>Company: thunisoft </p> 
	 * @param loginid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午3:12:14
	 */
	public String getUserNameByLoginid(String loginid) {
		User user = userDao.login(loginid);
		return user.getcName();
	}
	/**
	 * <p>Title: setUserRight</p>
	 * <p>Description: 保存权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @param rightkey
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:10:52
	 */
	public int setUserRight(String userid,String rightkey) {
		UserRight right = new UserRight();
		right.setcId(CommonUtils.getUUID());
		right.setcUserid(userid);
		right.setcRightkey(rightkey);
		right.setnType((byte)1);
		return userRightMap.insert(right);
	}
	/**
	 * <p>Title: saveAndUpdate</p>
	 * <p>Description: 保存更新权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userRights
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:28:30
	 */
	public int saveAndUpdate(UserRights userRights) {
		int result = 0;
		List<String> oldRights = userRightMap.getUserRights(userRights.getUserid());
		//插入
		if(userRights != null && userRights.getRightKeys() != null && userRights.getRightKeys().size() != 0) {
			for (String rightKey : userRights.getRightKeys()) {
				if(!oldRights.contains(rightKey)) {
					setUserRight(userRights.getUserid(),rightKey);
					result ++;
				}
			}
		}
		//删除
		if(oldRights != null && oldRights.size() != 0) {
			for (String oldRightKey : oldRights) {
				if(!userRights.getRightKeys().contains(oldRightKey)) {
					userRightMap.deleteUserRight(userRights.getUserid(),oldRightKey);
					result ++;
				}
			}
		}
		return result;
	}
	/**
	 * <p>Title: getUserRights</p>
	 * <p>Description: 获取用户权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:30:39
	 */
	public List<String> getUserRights(String userid){
		return userRightMap.getUserRights(userid);
	}
	/**
	 * <p>Title: getUserRights</p>
	 * <p>Description: 获取用户权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:30:39
	 */
	public List<String> getUserRightsByloginid(String loginid){
		return userRightMap.getUserRightsByloginid(loginid);
	}
}
