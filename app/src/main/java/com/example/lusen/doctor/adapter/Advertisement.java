package com.example.lusen.doctor.adapter;

/**
 * Created by wentai on 17-5-13.
 */

public class Advertisement {

    private String info;
    private int imgId;

    public Advertisement(String info, int imgId) {
        this.info = info;
        this.imgId = imgId;
    }

    public String getInfo() {
        return info;
    }

    public int getImgId() {
        return imgId;
    }
}
