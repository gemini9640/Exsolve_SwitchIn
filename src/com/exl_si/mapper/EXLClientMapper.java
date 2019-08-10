package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EXLClient;

public interface EXLClientMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLClient record);

    int insertSelective(EXLClient record);

    EXLClient selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLClient record);

    int updateByPrimaryKey(EXLClient record);
    
    EXLClient login(@Param("username")String username, @Param("password")String password);
    
    List<EXLClient> selectAll();
    
    EXLClient selectByUsernameAndPass(@Param("username")String username, @Param("password")String password);
    
    EXLClient selectByUsername(@Param("username")String username);
}