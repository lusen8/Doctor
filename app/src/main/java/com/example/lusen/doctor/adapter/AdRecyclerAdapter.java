package com.example.lusen.doctor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.lusen.doctor.R;

public class AdRecyclerAdapter extends RecyclerView.Adapter<AdRecyclerAdapter.ViewHolder> {

    private List<Advertisement> ads = new ArrayList<>();

    public AdRecyclerAdapter(List<Advertisement> ads) {
        this.ads = ads;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Advertisement ad = ads.get(position);
        holder.ad_img.setImageResource(ad.getImgId());
        holder.ad_title.setText(ad.getInfo());
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView ad_title;
        ImageView ad_img;

        public ViewHolder(View itemView) {
            super(itemView);
            ad_title = (TextView) itemView.findViewById(R.id.title_ad);
            ad_img = (ImageView) itemView.findViewById(R.id.img_ad);
        }
    }

}
