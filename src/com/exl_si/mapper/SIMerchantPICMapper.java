package com.exl_si.mapper;

import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.SIMerchantPICKey;

public interface SIMerchantPICMapper {
    int deleteByPrimaryKey(SIMerchantPICKey key);

    int insert(SIMerchantPIC record);

    int insertSelective(SIMerchantPIC record);

    SIMerchantPIC selectByPrimaryKey(SIMerchantPICKey key);

    int updateByPrimaryKeySelective(SIMerchantPIC record);

    int updateByPrimaryKey(SIMerchantPIC record);
}