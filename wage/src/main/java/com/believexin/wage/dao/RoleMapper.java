package com.believexin.wage.dao;

import com.believexin.wage.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}