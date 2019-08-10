package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.Event;

public interface EventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
    
    List<Event> selectByMerchant(String merchantId);
    
    int updateStatus(@Param("id")Integer id, @Param("status")Integer status);
}