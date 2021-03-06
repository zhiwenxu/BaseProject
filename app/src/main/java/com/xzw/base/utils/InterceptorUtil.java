package com.xzw.base.utils;

/**
 * Created by draven.xu on 17/12/22.
 */

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author yemao
 * @date 2017/4/9
 * @description 拦截器工具类!
 */

public class InterceptorUtil {
    public static String TAG="----";
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w(TAG, "log: "+message );
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    //头部拦截器
    public static Interceptor HeaderInterceptor(){
        return   new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mRequest=chain.request();
                //在这里你可以做一些想做的事,比如token失效时,重新获取token
                //或者添加header等等,PS我会在下一篇文章总写拦截token方法
                return chain.proceed(mRequest);
            }
        };

    }
}
