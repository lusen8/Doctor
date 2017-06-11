package com.example.lusen.doctor.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lusen.doctor.R;
import com.example.lusen.doctor.adapter.Food;
import com.example.lusen.doctor.adapter.FoodRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusen on 2017/6/11.
 */

public class RecordFragment1 extends Fragment {

    private final static String RECORDURL = "http://139.199.63.27/history.php";
    private List<Food> foods;
    private RecyclerView recyclerView;
    private FoodRecyclerAdapter adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1_record,null,false);
        foods = new ArrayList<>();
//        getRecord(RECORDURL);
        initFoods();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecordFragment1.SpaceItemDecoration(28));
        adapter = new FoodRecyclerAdapter(getActivity(), foods);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void initFoods() {
        Food food1 = new Food(R.drawable.food1, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求","￥4");
        foods.add(food1);
        Food food2 = new Food(R.drawable.food2, "煎蛋面包，早餐，我～的最爱","￥5");
        foods.add(food2);
        Food food3 = new Food(R.drawable.food3, "要想早餐吃得饱，两枚鸡蛋少不了，Prefecte!","￥5");
        foods.add(food3);
        Food food4 = new Food(R.drawable.food4, "水果早餐，当然要属香蕉啦！保持好身材","￥3");
        foods.add(food4);
        Food food5 = new Food(R.drawable.food5, "你说什么？想要喝的？皮蛋瘦肉粥啊！","￥5");
        foods.add(food5);
        Food food6 = new Food(R.drawable.food6, "鸡蛋羹说，她可以给你想要的营养，还在等什么！","￥3.5");
        foods.add(food6);
        Food food7 = new Food(R.drawable.food7, "小面包,当然要来找小光啊！据说还有水果呦！","￥3");
        foods.add(food7);
        Food food8 = new Food(R.drawable.food8, "听说三明治和牛奶更配哦！","￥5");
        foods.add(food8);
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace ;

        //传入的值，其单位视为dp
        public SpaceItemDecoration(int space) {
            this.mSpace = DensityUtils.dp2px(getActivity(), space);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int itemCount = adapter.getItemCount();
            int pos = parent.getChildAdapterPosition(view);

            outRect.left = 0;
            outRect.top = 0;
            outRect.bottom = 0;


            if (pos != (itemCount -1)) {
                outRect.bottom = mSpace;
            } else {
                outRect.right = 0;
            }
        }
    }

    public static class DensityUtils {
        //dp->dx
        public static int dp2px(Context context, float dpVal) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dpVal, context.getResources().getDisplayMetrics());
        }
    }


}
