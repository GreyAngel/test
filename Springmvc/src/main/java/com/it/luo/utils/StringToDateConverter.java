package com.it.luo.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串转换成Date日期
 */
public class StringToDateConverter implements Converter<String , Date> {

    /**
     * source 传入的字符串
     * @param source
     * @return
     */
    public Date convert(String source) {
        if( source == null){
            throw new RuntimeException("传入的日期数据不能为null");
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return format.parse(source);
        } catch (Exception e) {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            try {
                return df.parse(source);
            } catch (Exception e1) {
                throw new RuntimeException("数据类型转换出现错误");
            }

        }
    }

    public static void main(String[] args) {
        String source = "2010-05-19";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(format.parse(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
