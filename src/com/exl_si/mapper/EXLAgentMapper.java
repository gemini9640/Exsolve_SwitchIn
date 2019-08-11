package com.exl_si.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EXLAgent;

public interface EXLAgentMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLAgent record);

    int insertSelective(EXLAgent record);

    EXLAgent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLAgent record);

    int updateByPrimaryKey(EXLAgent record);
    
    EXLAgent login(@Param("username")String username, @Param("password")String password);
    
    List<EXLAgent> selectAll();
    
    List<EXLAgent> selectByPropertiesSelelctives(Map<String, Object> map);
    
    EXLAgent selectByUsernameAndPass(@Param("username")String username, @Param("password")String password);
    
    EXLAgent selectByUsername(@Param("username")String username);
}