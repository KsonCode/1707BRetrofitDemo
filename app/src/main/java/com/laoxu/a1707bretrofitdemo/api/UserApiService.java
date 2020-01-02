package com.laoxu.a1707bretrofitdemo.api;

import com.laoxu.a1707bretrofitdemo.entity.UserEntity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface UserApiService {


    @POST("small/user/v1/login")
    @FormUrlEncoded
    Call<UserEntity> login(@Field("phone") String phone, @Field("pwd") String password);

    @POST("small/user/v1/login")
    @FormUrlEncoded
    Call<UserEntity> login2(@FieldMap HashMap<String, String> params);


    @POST
    @FormUrlEncoded
    Call<UserEntity> login3(@Url String url, @FieldMap HashMap<String, String> params);

    @PUT("small/user/verify/v1/modifyUserNick")
    @FormUrlEncoded
    Call<UserEntity> updataNickname(@Header("userId") String uid, @Header("sessionId") String sid, @Field("nickName") String name);

    @PUT("small/user/verify/v1/modifyUserNick")
    @FormUrlEncoded
    Call<UserEntity> updataNickname2(@HeaderMap HashMap<String, String> params, @Field("nickName") String name);


}
