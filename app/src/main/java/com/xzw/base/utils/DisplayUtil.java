package com.xzw.base.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by dmsoft on 2017/9/8.
 */

public class DisplayUtil {

    /**
     * 获取屏幕的宽高
     */
    public static Point getScreanMetrics(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return new Point(dm.widthPixels,dm.heightPixels);
    }

    public int dp2px(Context context,float value){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value * scale +0.5f);
    }
    public int px2dp(Context context,float value){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((value / scale) + 0.5f);
    }

}
