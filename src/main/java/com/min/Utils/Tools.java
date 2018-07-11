package com.min.Utils;


import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description: 工具类
 * User: minchenyang
 * Date: 2018-03-15
 * Time: 4:03
 */

public class Tools {

    /**
     * 判断字符串格式是否为ip格式
     *
     * @param str 字符串
     * @return boolean 字符串是否为ip格式
     */
    //判断是否为ip
    public static boolean isIP(String str) {

        //正则ip条件
        String regex = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(str).matches();

    }

    /**
     * 得到UUID 去掉- 的字符串
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }


}