package com.xzw.base.http.api;


import com.xzw.base.http.entity.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 抽象封装观察者类
 * Created by draven.xu on 17/12/22.
 */

public abstract class APIObserver<T> implements Observer<BaseEntity<T>> {

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {
        onSuccess(tBaseEntity);
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    //请求成功后回调
    protected abstract void onSuccess(BaseEntity<T> tBaseEntity);
    //网络失败后回到
    protected abstract void onFailure(Throwable e);
}
