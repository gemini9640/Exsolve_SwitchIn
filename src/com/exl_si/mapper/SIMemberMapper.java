package com.exl_si.mapper;

import com.exl_si.db.SIMember;

public interface SIMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SIMember record);

    int insertSelective(SIMember record);

    SIMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SIMember record);

    int updateByPrimaryKey(SIMember record);
}