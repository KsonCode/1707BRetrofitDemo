package com.laoxu.a1707bretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.laoxu.a1707bretrofitdemo.adapter.LeftAdapter;
import com.laoxu.a1707bretrofitdemo.adapter.RightAdapter;
import com.laoxu.a1707bretrofitdemo.contract.ClzContract;
import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;
import com.laoxu.a1707bretrofitdemo.entity.GreendaoEntity;
import com.laoxu.a1707bretrofitdemo.entity.RightEntity;
import com.laoxu.a1707bretrofitdemo.greendao.DaoMaster;
import com.laoxu.a1707bretrofitdemo.greendao.DaoSession;
import com.laoxu.a1707bretrofitdemo.presenter.ClsPresenter;
import com.laoxu.a1707bretrofitdemo.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

public class ClsActivity extends AppCompatActivity implements ClzContract.IView {
    DaoMaster.DevOpenHelper helper;


    private RecyclerView leftRv;
    private RecyclerView rightRv;
    private ClsPresenter clsPresenter;
    private SQLiteDatabase sqLiteDatabase;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cls);
        clsPresenter = new ClsPresenter(this);

        leftRv = findViewById(R.id.rv_left);
        rightRv = findViewById(R.id.rv_right);
        leftRv.setLayoutManager(new LinearLayoutManager(this));
        rightRv.setLayoutManager(new GridLayoutManager(this,2));

        //注册eventbus
        EventBus.getDefault().register(this);


        //数据库帮助类，创建数据库，以clsdb名字
        helper1 = new DaoMaster.DevOpenHelper(this,"clsdb");
        //创建数据库的读写工具类
        sqLiteDatabase = helper1.getWritableDatabase();
        //创建daomaster对象
        daoMaster = new DaoMaster(sqLiteDatabase);
        //创建daosesiion
        daoSession = daoMaster.newSession();

        if (RetrofitUtils.getInstance().isNet()){//伪代码，网络判断
            clsPresenter.getLeftData();
        }else{
            List<GreendaoEntity> greendaoEntities = daoSession.getGreendaoEntityDao().loadAll();
            if (greendaoEntities!=null&&greendaoEntities.size()>0){
                GreendaoEntity greendaoEntity = greendaoEntities.get(0);//第0条数据
                String json = greendaoEntity.getJson();
                ClsEntity clsEntity = new Gson().fromJson(json,ClsEntity.class);
                //只获取一级女装下的二级列表数据
                LeftAdapter leftAdapter = new LeftAdapter(this,clsEntity.result.get(0).secondCategoryVo);

                leftRv.setAdapter(leftAdapter);

                //接口回调的实现，得到值了
                leftAdapter.setLeftClick(new LeftAdapter.LeftClick() {
                    @Override
                    public void leftItemClick(String id) {

                        //发送
                        EventBus.getDefault().post(id);

                    }
                });
            }
        }
    }

    @Override
    public void success(Object o) {

        //请求左侧分类的json串串
        if (o instanceof ClsEntity){
            ClsEntity clsEntity = (ClsEntity) o;
            //只获取一级女装下的二级列表数据
            LeftAdapter leftAdapter = new LeftAdapter(this,clsEntity.result.get(0).secondCategoryVo);

            leftRv.setAdapter(leftAdapter);

            //接口回调的实现，得到值了
            leftAdapter.setLeftClick(new LeftAdapter.LeftClick() {
                @Override
                public void leftItemClick(String id) {

                    //发送
                    EventBus.getDefault().post(id);

                }
            });



            //缓存数据
            GreendaoEntity greendaoEntity = new GreendaoEntity();
            String json = new Gson().toJson(clsEntity);
            greendaoEntity.setJson(json);
            greendaoEntity.setKey("分类");
            daoSession.getGreendaoEntityDao().insert(greendaoEntity);




        }else if (o instanceof RightEntity){
            RightEntity rightEntity = (RightEntity) o;
            RightAdapter rightAdapter = new RightAdapter(this,rightEntity.result);
            rightRv.setAdapter(rightAdapter);


        }

    }

    /**
     * 接收二级类目的id
     * @param id
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getId(String id){

        HashMap<String,String> params = new HashMap<>();
        params.put("categoryId",id);
        params.put("page","1");
        params.put("count","10");
        clsPresenter.getRightData(params);

    }

    @Override
    public void failure(Throwable throwable) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
