package com.exl_si.mapper;

import com.exl_si.db.EventPicture;

public interface EventPictureMapper {
    int insert(EventPicture record);

    int insertSelective(EventPicture record);
}