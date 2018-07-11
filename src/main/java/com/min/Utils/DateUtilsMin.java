package com.min.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: CenterSoc
 * @description: 时间工具类
 * @author: mcy
 * @create: 2018-06-29 15:33
 **/
public class DateUtilsMin {

    /**
     * 将时间戳根据时间格式转换成对应的字符串
     * @param time 时间戳
     * @param format 时间格式
     * @return
     */
    public static String timestampToDataStringByFormat(Long time, String format){
        Date date = new Date(time);
        if(format==null){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date dateStringToTimestampByFormat(String time, String format)throws ParseException{
        if(format==null){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(time);
    }

}
