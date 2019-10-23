package com.exl_si.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMember;

public interface SIMemberMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(SIMember record);

    SIMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMember record);

    
    List<SIMember> selectAll();
    
    List<SIMember> selectByPropertiesSelelctives(Map<String, Object> map);
    
    SIMember login(@Param("username")String username, @Param("password")String password);
    
    SIMember selectByKeyAndPass(@Param("username")String username, @Param("password")String password);
    
    SIMember selectByUsername(@Param("username")String username);
}