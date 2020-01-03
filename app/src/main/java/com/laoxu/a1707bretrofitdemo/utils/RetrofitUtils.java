package com.laoxu.a1707bretrofitdemo.utils;

import com.blankj.utilcode.util.NetworkUtils;
import com.laoxu.a1707bretrofitdemo.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        //第一步
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)//关联okhttp的
                //工厂模式，java有23种
                .addConverterFactory(GsonConverterFactory.create())//数据转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//rxjava的请求回调适配器
                .build();

    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils==null){

            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){

                    retrofitUtils = new RetrofitUtils();
                }
            }

        }
        return retrofitUtils;
    }

    /**
     * 动态获取接口管理类对象
     * @param tClass
     * @param <T>
     * @return
     */
    public <T>T createservice(Class<T> tClass){
//        IHomeApiService iHomeApiService = retrofit.create(IHomeApiService.class);
        T t = retrofit.create(tClass);
        return t;
    }

    /**
     * 判断是否有网
     * @return
     */
    public boolean isNet(){
        return NetworkUtils.isConnected();

    }


}
