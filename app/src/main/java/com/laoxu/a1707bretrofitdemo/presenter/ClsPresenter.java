package com.laoxu.a1707bretrofitdemo.presenter;

import com.laoxu.a1707bretrofitdemo.contract.ClzContract;
import com.laoxu.a1707bretrofitdemo.model.ClsModel;

import java.util.HashMap;

public class ClsPresenter implements ClzContract.IPresenter {

    private ClzContract.IView iView;

    private ClsModel clsModel;

    public ClsPresenter(ClzContract.IView iView) {
        this.iView = iView;
        this.clsModel = new ClsModel();
    }

    @Override
    public void getLeftData() {

        clsModel.getLeftData(new ClzContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {

                iView.success(o);

            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);

            }
        });

    }

    @Override
    public void getRightData(HashMap<String, String> params) {

        clsModel.getRightData(params, new ClzContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void failure(Throwable throwable) {

                iView.failure(throwable);
            }
        });
    }
}
