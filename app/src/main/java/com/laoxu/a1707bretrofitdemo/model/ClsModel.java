package com.laoxu.a1707bretrofitdemo.model;

import com.laoxu.a1707bretrofitdemo.api.ClsApiservice;
import com.laoxu.a1707bretrofitdemo.contract.ClzContract;
import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;
import com.laoxu.a1707bretrofitdemo.entity.RightEntity;
import com.laoxu.a1707bretrofitdemo.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClsModel implements ClzContract.IModel {
    @Override
    public void getLeftData(final ModelCallback modelCallback) {

//        Observable observable = null;//被观察者
//        Observer observer = null;//观察者
//        observable.subscribe(observer);


        RetrofitUtils.getInstance().createservice(ClsApiservice.class)
                .getCls()//获取rxjava的被观察者，observable对象
                .subscribeOn(Schedulers.io())//指定obserable被观察者所在线程（请求网络的线程）
                .observeOn(AndroidSchedulers.mainThread())//指定observer观察者所在线程（响应后的数据所在的线程，onnext方法运行的线程）
                .subscribe(new Observer<ClsEntity>() {//订阅关系
                    /**
                     * 是否订阅成功
                     * @param d
                     */
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    /**
                     * 接收成功
                     * @param value
                     */
                    @Override
                    public void onNext(ClsEntity value) {

                        modelCallback.success(value);
                    }

                    /**
                     * 失败
                     * @param e
                     */
                    @Override
                    public void onError(Throwable e) {

                        modelCallback.failure(e);

                    }

                    /**
                     * 接收完成
                     */
                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightData(HashMap<String, String> params, final ModelCallback modelCallback) {


        RetrofitUtils.getInstance().createservice(ClsApiservice.class)
                .getRight(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {

                        modelCallback.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.failure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
