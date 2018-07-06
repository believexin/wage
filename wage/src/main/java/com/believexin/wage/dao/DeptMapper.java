package com.believexin.wage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.believexin.wage.pojo.Dept;
@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    /**
     * <p>Title: query</p>
     * <p>Description: 获取所有部门</p>
     * <p>Company: thunisoft </p> 
     * @return
     * @author zhangxin
     * @date 2018年4月6日 下午12:09:37
     */
    List<Dept> query();
}