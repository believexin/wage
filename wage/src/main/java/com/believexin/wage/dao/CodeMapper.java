package com.believexin.wage.dao;

import com.believexin.wage.pojo.Code;
import com.believexin.wage.pojo.CodeKey;

public interface CodeMapper {
    int deleteByPrimaryKey(CodeKey key);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(CodeKey key);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
}