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
import com.example.lusen.doctor.date.Food;
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
        Food food1 = new Food(R.drawable.food1, "幸福不是从不感冒，而是感冒时传递的那一杯温暖。","￥4");
        foods.add(food1);
        Food food2 = new Food(R.drawable.food2, "感冒了，不喝板蓝根，一个传染俩","￥5");
        foods.add(food2);
        Food food3 = new Food(R.drawable.food3, "小柴胡，孩子感冒老不好，小柴胡来帮忙！","￥5");
        foods.add(food3);
        Food food4 = new Food(R.drawable.food4, "什么还有这种操作？感冒片！强！","￥3");
        foods.add(food4);
        Food food5 = new Food(R.drawable.food5, "再说一遍，葵花牌克感利咽，小葵花治感冒啦！","￥5");
        foods.add(food5);
        Food food6 = new Food(R.drawable.food6, "口服液还可以抗病毒，我没听错吧！","￥3.5");
        foods.add(food6);
        Food food7 = new Food(R.drawable.food7, "双黄连口服液，感冒吃黄连，好的贼快！","￥3");
        foods.add(food7);
        Food food8 = new Food(R.drawable.food8, "新版小柴胡，一样的功效呦！","￥5");
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
