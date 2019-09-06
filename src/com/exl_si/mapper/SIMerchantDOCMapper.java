package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.SIMerchantDOC;

public interface SIMerchantDOCMapper {
	int deleteByPrimaryKey(String id);

    int insert(SIMerchantDOC record);

    int insertSelective(SIMerchantDOC record);

    SIMerchantDOC selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMerchantDOC record);

    int updateByPrimaryKey(SIMerchantDOC record);
    
    int batchInsert(@Param("items")List<SIMerchantDOC> items);
    
    List<SIMerchantDOC> selectByMerchantIdAndType(@Param("merchantId")String merchantId, @Param("type")String type);
}