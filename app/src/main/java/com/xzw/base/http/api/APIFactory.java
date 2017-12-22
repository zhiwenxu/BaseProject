package com.xzw.base.http.api;

import com.xzw.base.http.config.HttpConfig;
import com.xzw.base.utils.InterceptorUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 静态内部类单例模式
 * Created by draven.xu on 17/12/22.
 */

public class APIFactory {

    private static APIService mService;

    private APIFactory(){
        initRetrofit();
    }
    //获取实例
    public static APIFactory getInstance(){
        return APIFactoryHolder.mInstance;
    }

    //静态内部类
    private static class APIFactoryHolder{
        private static final APIFactory mInstance = new APIFactory();
    }

    //初始化Retrofit和OkHttp
    private void initRetrofit(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .readTimeout(HttpConfig.HTTP_TIME,TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.HTTP_TIME,TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.LogInterceptor())
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mService = retrofit.create(APIService.class);

    }

    //网络请求接口
    public APIService API(){
        return mService;
    }

    //主线程和子线程的切换封装

    public static <T> ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T,T>() {
            @Override
            public ObservableSource<T>  apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}
