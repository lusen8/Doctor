package com.example.lusen.doctor.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lusen.doctor.util.NetChangeObserver;
import com.example.lusen.doctor.util.NetStateReceiver;
import com.example.lusen.doctor.util.NetStateUtils;

/**
 * Created by lusen on 2017/6/9.
 */

public abstract class NetConnectActivity extends AppCompatActivity {

    /**
     * 网络观察者
     */
    protected NetChangeObserver mNetChangeObserver = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 网络改变的一个回掉类
        mNetChangeObserver = new NetChangeObserver() {

            @Override
            public void onNetConnected(NetStateUtils.NetType type) {

            }

            @Override
            public void onNetDisConnect() {
                onNetworkDisConnected();
            }
        };

        //开启广播去监听 网络 改变事件
        NetStateReceiver.registerObserver(mNetChangeObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 网络连接状态
     *
     * @param type 网络状态
     */
    protected abstract void onNetworkConnected(NetStateUtils.NetType type);

    /**
     * 网络断开的时候调用
     */
    protected abstract void onNetworkDisConnected();

}