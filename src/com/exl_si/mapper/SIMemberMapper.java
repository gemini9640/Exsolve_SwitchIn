package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMember;

public interface SIMemberMapper {
    int deleteByPrimaryKey(String username);

    int insert(SIMember record);

    int insertSelective(SIMember record);

    SIMember selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(SIMember record);

    int updateByPrimaryKey(SIMember record);
    
    List<SIMember> selectAll();
    
    SIMember login(@Param("username")String id, @Param("password")String password);
    
    SIMember selectByKeyAndPass(@Param("username")String username, @Param("password")String password);
}