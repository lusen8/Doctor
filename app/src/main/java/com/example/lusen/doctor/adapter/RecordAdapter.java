package com.example.lusen.doctor.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.lusen.doctor.R;
import com.example.lusen.doctor.model.Person;

/**
 * Created by lusen on 2017/5/8.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_TEXT = 2;

    private Activity activity;
    private int foodId;
    private ArrayList<Person> personList;

    public RecordAdapter(Activity activity, ArrayList<Person> personList){
        this.activity = activity;
        this.personList = personList;
    }

    public void setPersonList(ArrayList<Person> personList){
        this.personList = personList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(activity);
        MyHolder holder = null;
        if(viewType == TYPE_NORMAL){
            View v = mInflater.inflate(R.layout.item_record,parent,false);
            holder = new MyHolder(v);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_NORMAL;
//        用于多布局
//        if(position == 0) return TYPE_HEADER;
//        if (position == 1) return TYPE_TEXT;
//        return TYPE_NORMAL;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String title = null;
        switch (personList.get(position).getId()){
            case 1: title = "豆浆加奶酪，完美组合，满足你每天的蛋白质需求";foodId = R.drawable.food1;break;
            case 2: title = "煎蛋面包，早餐，我～的最爱";foodId = R.drawable.food2;break;
            case 3: title = "要想早餐吃得饱，两枚鸡蛋少不了，Prefecte!";foodId = R.drawable.food3;break;
            case 4: title = "水果早餐，当然要属香蕉啦！保持好身材";foodId = R.drawable.food4;break;
            case 5: title = "你说什么？想要喝的？皮蛋瘦肉粥啊！";foodId = R.drawable.food5;break;
            case 6: title = "鸡蛋羹说，她可以给你想要的营养，还在等什么！";foodId = R.drawable.food6;break;
            case 7: title = "小面包,当然要来找小光啊！据说还有水果呦！";foodId = R.drawable.food7;break;
            default: title = "听说三明治和牛奶更配哦！"; foodId = R.drawable.food8;

        }
        ((MyHolder) holder).record_tv.setText(title);
        ((MyHolder) holder).record_data.setText(String.valueOf(personList.get(position).getStarttime()));
        ((MyHolder) holder).image.setImageResource(foodId);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView record_tv;
        private TextView record_data;
        private ImageView image;
        private CardView cardView;
        public MyHolder(View itemView) {
            super(itemView);
            record_tv= (TextView) itemView.findViewById(R.id.record_tv);
            record_data= (TextView) itemView.findViewById(R.id.record_data);
            image = (ImageView) itemView.findViewById(R.id.record_img);
            cardView = (CardView) itemView.findViewById(R.id.reccord_card);

        }
    }

}
