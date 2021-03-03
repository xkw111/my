package com.sc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date>
{

    public Date convert(String source) {
        Date date=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            date=simpleDateFormat.parse(source);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
