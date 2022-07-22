package com.offcn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 作为一个工具类 以后可以直接使用
public class DateUtil {
    // 根据格式 将日期转为字符串 将字符串转为日期
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 工具特征 构造私有
    private DateUtil(){}

    // 字符串转日期
    public static Date stringToDate(String str){
        Date date = null;
        try{
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date){
        return sdf.format(date);
    }
}
