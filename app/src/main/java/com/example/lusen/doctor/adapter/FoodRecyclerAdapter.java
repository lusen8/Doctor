package com.example.lusen.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.lusen.doctor.PayActivity;
import com.example.lusen.doctor.R;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Food> foods = new ArrayList<>();

    public FoodRecyclerAdapter(Context context, List<Food> foods) {
        this.foods = foods;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PayActivity.class);
                intent.putExtra("name", foods.get(viewType).getInfo());
                intent.putExtra("money", foods.get(viewType).getMoney());
                intent.putExtra("imageId",foods.get(viewType).getImgId());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Food ad = foods.get(position);
        holder.ad_img.setImageResource(ad.getImgId());
        holder.ad_money.setText(ad.getMoney());
        holder.ad_title.setText(ad.getInfo());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView ad_title;
        TextView ad_money;
        ImageView ad_img;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ad_money = (TextView) itemView.findViewById(R.id.foodMoney);
            ad_title = (TextView) itemView.findViewById(R.id.foodTxt);
            ad_img = (ImageView) itemView.findViewById(R.id.foodPic);
        }
    }

}
