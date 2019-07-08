package com.exl_si.mapper;

import com.exl_si.db.SIMerchant;

public interface SIMerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SIMerchant record);

    int insertSelective(SIMerchant record);

    SIMerchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SIMerchant record);

    int updateByPrimaryKey(SIMerchant record);
}