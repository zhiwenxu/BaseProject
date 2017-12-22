package com.xzw.base.http.api;


import com.xzw.base.http.entity.BaseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by draven.xu on 17/12/22.
 */

public interface APIService {

    @GET("RemoteDoctor/login")
    Observable<BaseEntity<String>> login();

}
