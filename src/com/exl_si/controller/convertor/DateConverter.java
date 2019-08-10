package com.exl_si.controller.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");// 小写的mm表示的是分钟
    Date date = new Date();

    @Override
    public Date convert(String source) {
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            logger.error("converting error, candidate is {}",source);
            e.printStackTrace();
        }
        return date;
    }

}