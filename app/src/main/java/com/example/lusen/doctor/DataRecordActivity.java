package com.example.lusen.doctor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lusen.doctor.adapter.RecordAdapter;
import com.example.lusen.doctor.base.NetConnectActivity;
import com.example.lusen.doctor.model.Person;
import com.example.lusen.doctor.util.MyGsonUtil;
import com.example.lusen.doctor.util.MyHttpURL;
import com.example.lusen.doctor.util.NetStateReceiver;
import com.example.lusen.doctor.util.NetStateUtils;

import java.util.ArrayList;

import z.sye.space.library.PageStateLayout;
import z.sye.space.library.utils.PageState;


/**
 * Created by lusen on 2017/5/6.
 */

public class DataRecordActivity extends NetConnectActivity{


    private final static String RECORDURL = "http://139.199.63.27/history.php";

    private RecyclerView mRecordRecycle;
    private RecordAdapter mRecordAdapter;
    private ArrayList<Person> personList;

    private static final int LOADING = 0;
    private static final int EMPTY = 1;
    private static final int ERROR = 2;
    private static final int SUCCEED = 3;
    private static final int REQUESTING = 4;
    private long msgDelayed = 4000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SUCCEED:
                    pageStateLayout.onSucceed();
                    currentState = PageState.SUCCEED;
                    break;
                case ERROR:
                    pageStateLayout.onError();
                    currentState = PageState.ERROR;
            }
        }
    };

    private PageStateLayout pageStateLayout;
    private View succeedView;
    private ActionBar actionBar;

    private PageState currentState = PageState.SUCCEED;
    Message msg = new Message();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        pageStateLayout = new PageStateLayout(this);
        //实例化成功加载的View
        succeedView = LayoutInflater.from(this).inflate(R.layout.activity_record,null,false);
        //隐藏状态栏
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置成功加载后的界面
        pageStateLayout.load(this,succeedView);
        pageStateLayout.onLoading();
        //通过handle 将发送成功的消息传出，通知更新UI
        msg.what = SUCCEED;
        handler.sendMessageDelayed(msg, msgDelayed);
        pageStateLayout.setOnEmptyListener(new View.OnClickListener() {        //显示为空时候的点击事件
            @Override
            public void onClick(View view) {
                Log.d("我擦","竟然是空的");
            }
        });
        initView();
        getRecord(RECORDURL);
    }

    @Override
    protected void onNetworkConnected(NetStateUtils.NetType type) {
        Toast.makeText(this,"网络连接正常",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNetworkDisConnected() {
        Toast.makeText(this,"网络无连接",Toast.LENGTH_SHORT).show();
//        msg.what = ERROR;
//        handler.sendMessageDelayed(msg, msgDelayed);
    }

    @Override
    protected void onResume() {
        //注册广播机制
        NetStateReceiver.registerNetworkStateReceiver(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        //注销广播
        NetStateReceiver.unRegisterNetworkStateReceiver(this);
        super.onPause();
    }

    @Override
    //使用android 自带返回键，实现点击退出
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    //对加载事件进行判断
    public void onBackPressed() {
        if (currentState != PageState.SUCCEED) {
            pageStateLayout.onSucceed();
            currentState = PageState.SUCCEED;
        } else {
            super.onBackPressed();
        }
    }
    private void getRecord(String url){
        MyHttpURL.get(url, new MyHttpURL.Callback() {
            @Override
            public void onResponse(String response) {
                Log.d("网络请求数据",response);
                personList = (ArrayList<Person>) MyGsonUtil.getObjectList(response,Person.class);
                Log.d("解析后的数据",personList.get(3).getStarttime());
                addData();
            }
        });
    }

    private void addData(){
        mRecordAdapter.setPersonList(personList);
        mRecordRecycle.setAdapter(mRecordAdapter);
    }

    private void initView(){
        personList = new ArrayList<Person>();
        mRecordRecycle = (RecyclerView) findViewById(R.id.recycle_recode);
        mRecordRecycle.setLayoutManager(new LinearLayoutManager(this));
        mRecordAdapter = new RecordAdapter(this,personList);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


}
