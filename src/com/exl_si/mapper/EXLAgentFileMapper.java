package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EXLAgentFile;

public interface EXLAgentFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLAgentFile record);

    int insertSelective(EXLAgentFile record);

    EXLAgentFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLAgentFile record);

    int updateByPrimaryKey(EXLAgentFile record);
    
    int batchInsert(@Param("items")List<EXLAgentFile> items);
    
    EXLAgentFile selectByAgentId(String agentId);
}