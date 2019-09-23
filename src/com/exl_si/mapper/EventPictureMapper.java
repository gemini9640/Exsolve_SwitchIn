package com.exl_si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exl_si.db.EventPicture;

public interface EventPictureMapper {
	int deleteByPrimaryKey(String id);

    int insert(EventPicture record);

    int insertSelective(EventPicture record);

    EventPicture selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EventPicture record);

    int updateByPrimaryKey(EventPicture record);
    
    int batchInsert(@Param("items")List<EventPicture> items);
    
    List<EventPicture> selectByEventIdAndType(@Param("eventId")String eventId, @Param("type")String type);
}