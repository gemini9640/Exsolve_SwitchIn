package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMemberFile;

public interface SIMemberFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(SIMemberFile record);

    int insertSelective(SIMemberFile record);

    SIMemberFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMemberFile record);

    int updateByPrimaryKey(SIMemberFile record);
    
    int batchInsert(@Param("items")List<SIMemberFile> items);
}