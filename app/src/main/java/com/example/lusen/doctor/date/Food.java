package com.example.lusen.doctor.date;

/**
 * Created by wentai on 17-5-13.
 */

public class Food {

    private int imgId;
    private String info;
    private String money;

    public Food(int imgId, String info, String money) {
        this.imgId = imgId;
        this.info = info;
        this.money = money;
    }

    public String getInfo() {
        return info;
    }

    public int getImgId() {
        return imgId;
    }

    public String getMoney() { return money; }
}
