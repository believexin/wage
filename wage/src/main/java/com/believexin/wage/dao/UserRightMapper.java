package com.believexin.wage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.believexin.wage.pojo.UserRight;
@Mapper
public interface UserRightMapper {
    int deleteByPrimaryKey(String cId);

    int insert(UserRight record);

    int insertSelective(UserRight record);

    UserRight selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(UserRight record);

    int updateByPrimaryKey(UserRight record);
    
    List<String> getUserRights(String userid);
    
    List<String> getUserRightsByloginid(String loginid);
    
    int deleteUserRight(@Param("userid")String userid,@Param("rightKey")String rightKey);
    
}