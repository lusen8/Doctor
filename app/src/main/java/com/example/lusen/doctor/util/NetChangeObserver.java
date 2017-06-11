package com.example.lusen.doctor.util;

/**
 * 网络改变观察者，观察网络改变后回调的方法
 * Created by lusen on 2017/6/9.
 */
    public interface NetChangeObserver {

        /**
         * 网络连接回调 type为网络类型
         */
        void onNetConnected(NetStateUtils.NetType type);

        /**
         * 没有网络
         */
        void onNetDisConnect();
}

