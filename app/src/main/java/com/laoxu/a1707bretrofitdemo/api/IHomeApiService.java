package com.laoxu.a1707bretrofitdemo.api;

import com.laoxu.a1707bretrofitdemo.HomeEntity;
import com.laoxu.a1707bretrofitdemo.entity.BannerEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 接口请求配置类，管理类
 */
public interface IHomeApiService {

    @GET(Api.HOME_URL)
    Call<HomeEntity> getHome();

    @GET("small/commodity/v1/bannerShow")
    Call<BannerEntity> getBanner();
}
