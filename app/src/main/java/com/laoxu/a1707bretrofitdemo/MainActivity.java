package com.laoxu.a1707bretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.laoxu.a1707bretrofitdemo.api.Api;
import com.laoxu.a1707bretrofitdemo.api.IHomeApiService;
import com.laoxu.a1707bretrofitdemo.api.ProductService;
import com.laoxu.a1707bretrofitdemo.api.UserApiService;
import com.laoxu.a1707bretrofitdemo.entity.BannerEntity;
import com.laoxu.a1707bretrofitdemo.entity.ProductEntity;
import com.laoxu.a1707bretrofitdemo.entity.UserEntity;
import com.laoxu.a1707bretrofitdemo.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     */
    public void getClick(View view) {
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .build();
//
//        //第一步
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .client(okHttpClient)//关联okhttp的
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        //第二步，创建网络接口管理类
//        IHomeApiService iHomeApiService = retrofit.create(IHomeApiService.class);
//
//        //第三步，请求
//        iHomeApiService.getHome().enqueue(new Callback<HomeEntity>() {
//            @Override
//            public void onResponse(Call<HomeEntity> call, Response<HomeEntity> response) {
//                HomeEntity homeEntity = response.body();
//                Toast.makeText(MainActivity.this, homeEntity.message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<HomeEntity> call, Throwable t) {
//
//            }
//        });
//
//        iHomeApiService.getBanner().enqueue(new Callback<BannerEntity>() {
//            @Override
//            public void onResponse(Call<BannerEntity> call, Response<BannerEntity> response) {
//                BannerEntity bannerEntity = response.body();
//                Toast.makeText(MainActivity.this, bannerEntity.message, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<BannerEntity> call, Throwable t) {
//
//            }
//        });
//
//
//        ProductService productService = retrofit.create(ProductService.class);
//
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("keyword","手机");
//        params.put("page",1);
//        params.put("count",10);
//
//        productService.getProducts("手机",10,1).enqueue(new Callback<ProductEntity>() {
//            @Override
//            public void onResponse(Call<ProductEntity> call, Response<ProductEntity> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ProductEntity> call, Throwable t) {
//
//            }
//        });
//
//        productService.getProducts2(params).enqueue(new Callback<ProductEntity>() {
//            @Override
//            public void onResponse(Call<ProductEntity> call, Response<ProductEntity> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ProductEntity> call, Throwable t) {
//
//            }
//        });


        //动态代理模式
//        UserApiService userApiService = retrofit.create(UserApiService.class);
//
//        userApiService.login("18612991023","111111").enqueue(new Callback<UserEntity>() {
//            @Override
//            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
//                Toast.makeText(MainActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<UserEntity> call, Throwable t) {
//
//            }
//        });

//        long l = System.currentTimeMillis();

        HashMap<String,String> headerParams  = new HashMap<>();
        headerParams.put("userId","159");
        headerParams.put("sessionId","1577952207771159");
//修改昵称
        RetrofitUtils.getInstance().createservice(UserApiService.class)
                .updataNickname2(headerParams,"腊八节快了").enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                Toast.makeText(MainActivity.this, response.body().message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {

            }
        });


    }
}
