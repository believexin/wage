package com.believexin.wage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.believexin.wage.pojo.Corp;
@Mapper
public interface CorpMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Corp record);

    int insertSelective(Corp record);

    Corp selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Corp record);

    int updateByPrimaryKey(Corp record);
    /**
     * <p>Title: query</p>
     * <p>Description: 获取所有单位</p>
     * <p>Company: thunisoft </p> 
     * @return
     * @author zhangxin
     * @date 2018年4月6日 下午12:09:50
     */
    List<Corp> query();
}