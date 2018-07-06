package com.believexin.wage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.believexin.wage.pojo.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * <p>Title: query</p>
     * <p>Description: 获取所有用户</p>
     * <p>Company: thunisoft </p> 
     * @return
     * @author zhangxin
     * @date 2018年4月6日 下午12:09:20
     */
    List<User> query();
    /**
     * <p>Title: login</p>
     * <p>Description: 登录验证</p>
     * <p>Company: thunisoft </p> 
     * @param loginid
     * @return
     * @author zhangxin
     * @date 2018年4月26日 下午10:56:47
     */
    User login(@Param("loginid") String loginid);
}