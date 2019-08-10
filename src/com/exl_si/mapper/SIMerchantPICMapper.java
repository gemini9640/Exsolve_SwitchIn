package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMerchantPIC;

public interface SIMerchantPICMapper {
	int deleteByPrimaryKey(String username);

    int insert(SIMerchantPIC record);

    int insertSelective(SIMerchantPIC record);

    SIMerchantPIC selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(SIMerchantPIC record);

    int updateByPrimaryKey(SIMerchantPIC record);
    
    List<SIMerchantPIC> selectByMerchantId(@Param("merchantId")String merchantId);
}