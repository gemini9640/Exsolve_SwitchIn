package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMerchant;

public interface SIMerchantMapper {
    int deleteByPrimaryKey(String username);

    int insert(SIMerchant record);

    int insertSelective(SIMerchant record);

    SIMerchant selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(SIMerchant record);

    int updateByPrimaryKey(SIMerchant record);
    
    List<SIMerchant> selectAll();
    
    SIMerchant login(@Param("username")String id, @Param("password")String password);
    
    SIMerchant selectByKeyAndPass(@Param("username")String username, @Param("password")String password);
}