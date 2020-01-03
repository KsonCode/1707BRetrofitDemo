package com.laoxu.a1707bretrofitdemo.api;


import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;
import com.laoxu.a1707bretrofitdemo.entity.RightEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ClsApiservice {

//    @GET("small/commodity/v1/findCategory")
//    Call<ClsEntity> getCls();
    @GET("small/commodity/v1/findCategory")
    Observable<ClsEntity> getCls();


    @GET("small/commodity/v1/findCommodityByCategory")
    Observable<RightEntity> getRight(@QueryMap HashMap<String,String> params);
}
