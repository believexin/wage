package com.believexin.wage.dao;

import com.believexin.wage.pojo.RoleRight;

public interface RoleRightMapper {
    int deleteByPrimaryKey(String cId);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    RoleRight selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}