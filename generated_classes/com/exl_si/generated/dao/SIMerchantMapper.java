package com.exl_si.generated.dao;

import com.exl_si.generated.db.SIMerchant;

public interface SIMerchantMapper {
    int deleteByPrimaryKey(String id);

    int insert(SIMerchant record);

    int insertSelective(SIMerchant record);

    SIMerchant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SIMerchant record);

    int updateByPrimaryKey(SIMerchant record);
}