package com.exl_si.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMerchant;

public interface SIMerchantMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(SIMerchant record);

    SIMerchant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMerchant record);

    
    List<SIMerchant> selectAll();
    
    List<SIMerchant> selectByPropertiesSelelctives(Map<String, Object> map);
    
    SIMerchant login(@Param("username")String id, @Param("password")String password);
    
    SIMerchant selectByUsernameAndPass(@Param("username")String username, @Param("password")String password);
    
    SIMerchant selectByUsername(@Param("username")String username);
}