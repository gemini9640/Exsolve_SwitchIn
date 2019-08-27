package com.exl_si.mapper;

import com.exl_si.db.EXLAgentFile;

public interface EXLAgentFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLAgentFile record);

    int insertSelective(EXLAgentFile record);

    EXLAgentFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLAgentFile record);

    int updateByPrimaryKey(EXLAgentFile record);
}