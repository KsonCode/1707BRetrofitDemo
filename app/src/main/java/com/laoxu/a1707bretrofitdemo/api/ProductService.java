package com.laoxu.a1707bretrofitdemo.api;

import com.laoxu.a1707bretrofitdemo.entity.ProductEntity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ProductService {

    @GET("small/commodity/v1/findCommodityByKeyword")
    Call<ProductEntity> getProducts(@Query("keyword") String key,@Query("count") int count,@Query("page") int page);

    @GET("small/commodity/v1/findCommodityByKeyword")
    Call<ProductEntity> getProducts2(@QueryMap HashMap<String,Object> params);





}
