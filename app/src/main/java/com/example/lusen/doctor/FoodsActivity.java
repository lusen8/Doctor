package com.example.lusen.doctor;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lusen.doctor.adapter.Food;
import com.example.lusen.doctor.adapter.FoodRecyclerAdapter;
import com.example.lusen.doctor.adapter.TabViewAdapter;
import com.example.lusen.doctor.fragment.RecordFragment1;

import java.util.ArrayList;
import java.util.List;

public class FoodsActivity extends AppCompatActivity {

    private List<Food> foods;
    private RecyclerView recyclerView;
    private FoodRecyclerAdapter adapter;
    private ActionBar actionBar;

    private ViewPager mViewpager;
    private TabLayout mTabLayout;
    private TabViewAdapter myadapt;
    private List<Fragment> list;
    private ArrayList<String> titles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        initView();
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initView(){
        titles.add("日常药品");
        titles.add("保健品");
        titles.add("必备药品");
        titles.add("心血管药品");
        titles.add("非口服药");
        mViewpager = (ViewPager) findViewById(R.id.record_viewpager);
        mTabLayout=  (TabLayout)findViewById(R.id.tab_layout);
        myadapt = new TabViewAdapter(getSupportFragmentManager());
        myadapt.setTitle(titles);

        list = new ArrayList<Fragment>();
        //设置fragment
        for(int i=0;i<titles.size();i++){
            list.add(new RecordFragment1());
        }
        //设置要显示的fragment
        myadapt.setFragments(list);
        //设置TabLayout的模式    fix：固定tab的位置    scrollable：卷动tab
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //将FragmentPager的适配器传给viewpager，即设置viewpager的适配器
        mViewpager.setAdapter(myadapt);
        //绑定viewpager和TabLayout
        mTabLayout.setupWithViewPager(mViewpager);
    }

}
