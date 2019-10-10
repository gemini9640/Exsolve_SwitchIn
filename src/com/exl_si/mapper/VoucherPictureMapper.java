package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EventPicture;
import com.exl_si.db.VoucherPicture;

public interface VoucherPictureMapper {
    int deleteByPrimaryKey(String id);

    int insert(VoucherPicture record);

    int insertSelective(VoucherPicture record);

    VoucherPicture selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VoucherPicture record);

    int updateByPrimaryKey(VoucherPicture record);
    
    int batchInsert(@Param("items")List<VoucherPicture> items);
    
    List<VoucherPicture> selectByVoucherIdAndType(@Param("voucherId")String voucherId, @Param("type")String type);
}