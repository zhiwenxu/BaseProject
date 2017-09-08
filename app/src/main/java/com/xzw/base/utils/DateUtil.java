package com.xzw.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmsoft on 2017/7/29.
 * 获取当前时间
 */
public class DateUtil {
    public static String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date(System.currentTimeMillis()));
    }
}
