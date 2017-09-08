package com.xzw.base.utils;

/**
 * Created by xuzw-pc on 2017/9/7.
 */

public class StringUtil {

    //判断 字符串是否为空
    public static boolean isEmpty(String str){
        if(str == null || str.equals("") || str.equals("null")){
            return true;
        }
        return false;
    }

}
