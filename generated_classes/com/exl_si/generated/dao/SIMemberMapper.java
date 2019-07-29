package com.exl_si.generated.dao;

import com.exl_si.generated.db.SIMember;

public interface SIMemberMapper {
    int deleteByPrimaryKey(String username);

    int insert(SIMember record);

    int insertSelective(SIMember record);

    SIMember selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(SIMember record);

    int updateByPrimaryKey(SIMember record);
}