package com.example.lusen.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lusen.doctor.adapter.AdRecyclerAdapter;
import com.example.lusen.doctor.adapter.Advertisement;

import java.util.ArrayList;
import java.util.List;

public class AdActivity extends AppCompatActivity {

    private List<Advertisement> ads;
    private RecyclerView adsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        Toolbar toolbar = (Toolbar) findViewById(R.id.adToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adsRecycler = (RecyclerView) findViewById(R.id.adsRecycler);
        ads = new ArrayList<>();
        initAds();

        AdRecyclerAdapter adapter = new AdRecyclerAdapter(ads);
        adsRecycler.setLayoutManager(new LinearLayoutManager(this));
        adsRecycler.setAdapter(adapter);

    }

    private void initAds() {
        Advertisement ad1 = new Advertisement("123", R.drawable.ad1);
        ads.add(ad1);
        Advertisement ad2 = new Advertisement("12123", R.drawable.ad2);
        ads.add(ad2);
        Advertisement ad3 = new Advertisement("22", R.drawable.ad3);
        ads.add(ad3);
        Advertisement ad4 = new Advertisement("222", R.drawable.ad4);
        ads.add(ad4);
        Advertisement ad5 = new Advertisement("566", R.drawable.ad5);
        ads.add(ad5);
    }
}
