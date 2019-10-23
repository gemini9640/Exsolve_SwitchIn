package com.exl_si.generated.dao;

import com.exl_si.generated.db.SIMember;

public interface SIMemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(SIMember record);

    int insertSelective(SIMember record);

    SIMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMember record);

    int updateByPrimaryKey(SIMember record);
}