package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EXLClientFile;

public interface EXLClientFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLClientFile record);

    int insertSelective(EXLClientFile record);

    EXLClientFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLClientFile record);

    int updateByPrimaryKey(EXLClientFile record);
    
    int batchInsert(@Param("items")List<EXLClientFile> items);
    
    EXLClientFile selectByClientId(String client);
}