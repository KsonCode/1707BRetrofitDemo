package com.laoxu.a1707bretrofitdemo.contract;

import android.view.Display;

import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;

import java.util.HashMap;

public interface ClzContract {
    interface IModel{
        //左侧分类
        void getLeftData(ModelCallback modelCallback);
        //根据二级分类查询之下的商品
        void getRightData(HashMap<String,String> params, ModelCallback modelCallback);

        interface ModelCallback{
            void success(Object o);
            void failure(Throwable throwable);
        }


    }
    interface IView{

        void success(Object o);
        void failure(Throwable throwable);

    }
    interface IPresenter{
//左侧分类
        void getLeftData();
        //根据二级分类查询之下的商品
        void getRightData(HashMap<String,String> params);

    }
}
