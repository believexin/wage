package com.believexin.wage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.believexin.wage.common.model.PageInfo;
import com.believexin.wage.common.model.RightsTree;
import com.believexin.wage.common.model.UserRights;
import com.believexin.wage.pojo.OrganTree;
import com.believexin.wage.service.WageService;


@RestController
public class WageController {
	@Autowired
	WageService wageService;
	
	private SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
	/**
	 * <p>Title: getSalaryLevel</p>
	 * <p>Description: 获取员工角色（职务）</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年3月28日 下午11:22:49
	 */
	@RequestMapping("/getSalaryLevel")
	public Map<String, Object> getSalaryLevel(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> opinions = new ArrayList<>();
		List<Map<String,Object>> opinionData = new ArrayList<>();
		List<Map<String,Object>> list = wageService.getRoles();
		for (Map<String, Object> map : list) {
			String opinion = (String)map.get("name");
			long num = (Long)map.get("num");
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("value", num);
			dataMap.put("name", opinion);
			opinions.add(opinion);
			opinionData.add(dataMap);
		}
		result.put("opinions", opinions);
		result.put("opinionData", opinionData);
		return result;
	}
	/**
	 * <p>Title: getOrganTree</p>
	 * <p>Description: 获取组织机构树</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年4月7日 下午10:42:38
	 */
	@RequestMapping("/getOrganTree")
	public List<OrganTree> getOrganTree(){
		return wageService.getOrganTree();
	}
	@RequestMapping("/getUserSalaryInfo")
	public List<Map<String, Object>> getUserSalaryInfo(@Param("pageStart")String pageStart,@Param("pageCount")String pageCount){

		PageInfo pageInfo = new PageInfo();
		pageInfo.setThisPage(Integer.parseInt(pageStart));
		pageInfo.setPageStart(Integer.parseInt(pageCount) * (Integer.parseInt(pageStart) - 1));
		pageInfo.setPageCount(Integer.parseInt(pageCount));
		return wageService.getUserSalaryInfo(pageInfo);
	}
	@RequestMapping("/getUserSalaryInfoSize")
	public int getUserSalaryInfoSize(){
		return wageService.getUserAndSalaryForPageSize();
	}
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(String username,String password,ServletRequest servletRequest) {
		try {
			boolean flag = wageService.loginServer(username, password);
			if(flag) {
				HttpServletRequest request = (HttpServletRequest) servletRequest;
				HttpSession session = request.getSession();	
				session.setAttribute("username", username);
				return "success";
			}
		} catch (Exception e) {
			return "missing";
		}
		return "failure";
	}
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public void logout(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();	
		session.setAttribute("username", null);
	}
	@RequestMapping(value = "/getAvgWage" , method = RequestMethod.GET)
	public Map<String, Object> getAvgWage(){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("opinion", getAvgWageTjq());
		resultMap.put("opinionData", wageService.getAvgWage());
		return resultMap;
	}
	public List<String> getAvgWageTjq(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		List<String> dates = new ArrayList<>();
		
		c.add(Calendar.MONTH, -3);
		dates.add(dateFormater.format(c.getTime()));
		c.add(Calendar.MONTH, +1);
		dates.add(dateFormater.format(c.getTime()));
		c.add(Calendar.MONTH, +1);
		dates.add(dateFormater.format(c.getTime()));
		c.add(Calendar.MONTH, +1);
		dates.add(dateFormater.format(c.getTime()));
		return dates;
	}
	
	@RequestMapping(value = "/getAvgWageForUser" , method = RequestMethod.GET)
	public Map<String, Object> getAvgWageForUser(String userid){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("opinion", getAvgWageTjq());
		resultMap.put("opinionData", wageService.getAvgWageForUser(userid));
		return resultMap;
	}
	@RequestMapping(value = "/getRights" , method = RequestMethod.GET)
	public List<RightsTree> getRights(){
		return wageService.getRights();
	}
	@RequestMapping(value = "/getUserName" , method = RequestMethod.GET)
	public String getUserName(String loginid){
		if(loginid == null) {
			return "anonymous";
		}
		return wageService.getUserNameByLoginid(loginid);
	}
	/**
	 * <p>Title: saveAndUpdateRight</p>
	 * <p>Description: </p>
	 * <p>Company: thunisoft </p> 
	 * @param userRights
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:20:54
	 */
	@RequestMapping(value = "/saveAndUpdateRight" , method = RequestMethod.PUT)
	public boolean saveAndUpdateRight(@RequestBody UserRights userRights) {
		try {
			wageService.saveAndUpdate(userRights);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * <p>Title: getUserRights</p>
	 * <p>Description: 根据用户获取权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:48:45
	 */
	@RequestMapping(value = "/userRights" , method = RequestMethod.GET)
	public List<String> getUserRights(String userid){
		return wageService.getUserRights(userid);
	}
	/**
	 * <p>Title: getUserRights</p>
	 * <p>Description: 根据用户获取权限</p>
	 * <p>Company: thunisoft </p> 
	 * @param userid
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:48:45
	 */
	@RequestMapping(value = "/getUserRightsByloginid" , method = RequestMethod.GET)
	public List<String> getUserRightsByloginid(String loginid){
		return wageService.getUserRightsByloginid(loginid);
	}
}
