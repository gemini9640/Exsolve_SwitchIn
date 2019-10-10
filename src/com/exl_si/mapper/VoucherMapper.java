package com.exl_si.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.Voucher;

public interface VoucherMapper {
    int deleteByPrimaryKey(String id);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    Voucher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);
    
    List<Voucher> selectByMerchant(String merchantId);
    
    List<Voucher> selectByPropertiesSelective(Map<String, Object> map);
    
    int updateStatus(@Param("id")String id, @Param("status")Integer status);
    
    Voucher selectByName(@Param("voucherTitle")String voucherTitle);
}