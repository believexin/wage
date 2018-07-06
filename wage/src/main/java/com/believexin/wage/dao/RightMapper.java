package com.believexin.wage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.believexin.wage.pojo.Right;
@Mapper
public interface RightMapper {
    int deleteByPrimaryKey(String cRightkey);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectByPrimaryKey(String cRightkey);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
    
    List<Right> query();
}