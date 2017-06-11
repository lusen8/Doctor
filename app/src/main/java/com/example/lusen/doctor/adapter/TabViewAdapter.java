package com.example.lusen.doctor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusen on 2017/6/11.
 */

public class TabViewAdapter extends FragmentStatePagerAdapter {

    Fragment mFragments;
    List<Fragment> list;
    ArrayList<String> titles;

    public TabViewAdapter(FragmentManager fm) {
        super(fm);
    }
    //设置标题
    public void setTitle(ArrayList<String> title){
        titles=title;
    }
    //传入fragment容器
    public void setFragments(List<Fragment> fragments){
        list = fragments;
    }
    @Override
    //获取到fragment
    public Fragment getItem(int position) {
        return list.get(position);
    }
    //获取到标题
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
    @Override
    public int getCount() {
        return list.size();
    }

}
