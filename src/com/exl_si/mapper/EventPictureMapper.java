package com.exl_si.mapper;

import java.util.List;


import com.exl_si.db.EventPicture;

public interface EventPictureMapper {
    int insert(EventPicture record);

    int insertSelective(EventPicture record);
    
    int batchInsert(List<EventPicture> items);
}