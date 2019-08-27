package com.exl_si.mapper;

import com.exl_si.db.EXLClientFile;

public interface EXLClientFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(EXLClientFile record);

    int insertSelective(EXLClientFile record);

    EXLClientFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EXLClientFile record);

    int updateByPrimaryKey(EXLClientFile record);
}