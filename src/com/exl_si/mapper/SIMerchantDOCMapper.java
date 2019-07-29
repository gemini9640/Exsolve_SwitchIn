package com.exl_si.mapper;

import com.exl_si.generated.db.SIMerchantDOC;

public interface SIMerchantDOCMapper {
    int insert(SIMerchantDOC record);

    int insertSelective(SIMerchantDOC record);
}