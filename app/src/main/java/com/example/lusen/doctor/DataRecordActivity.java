package com.example.lusen.doctor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.lusen.doctor.adapter.RecordAdapter;
import com.example.lusen.doctor.model.Person;
import com.example.lusen.doctor.net.MyGsonUtil;
import com.example.lusen.doctor.net.MyHttpURL;

import java.util.ArrayList;


/**
 * Created by lusen on 2017/5/6.
 */

public class DataRecordActivity extends AppCompatActivity{

    private final static String RECORDURL = "http://139.199.63.27/history.php";

    private RecyclerView mRecordRecycle;
    private RecordAdapter mRecordAdapter;
    private ArrayList<Person> personList;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        getRecord(RECORDURL);
        initView();
//        addData();

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
