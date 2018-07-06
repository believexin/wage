package com.believexin.wage.dao;

import com.believexin.wage.pojo.CodeType;

public interface CodeTypeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(CodeType record);

    int insertSelective(CodeType record);

    CodeType selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(CodeType record);

    int updateByPrimaryKey(CodeType record);
}