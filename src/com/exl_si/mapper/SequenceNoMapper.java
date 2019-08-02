package com.exl_si.mapper;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SequenceNo;

public interface SequenceNoMapper {
    int insert(SequenceNo record);

    int insertSelective(SequenceNo record);
    
    String selectByField(@Param("field")String field);
    
    int updateByField(@Param("field")String field, @Param("total")Integer total);
}