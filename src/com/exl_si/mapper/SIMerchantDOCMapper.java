package com.exl_si.mapper;

import java.util.List;

import com.exl_si.db.SIMerchantDOC;

public interface SIMerchantDOCMapper {
    int insert(SIMerchantDOC record);

    int insertSelective(SIMerchantDOC record);
    
    int batchInsert(List<SIMerchantDOC> items);
}