package com.example.checkbox;

import android.content.Intent;

public class Data {
    String namePhone;
    String price;
    boolean isCheck;
    int img;


    public Data(String namePhone, String price, int img,Boolean isCheck) {
        this.namePhone = namePhone;
        this.price = price;
        this.img = img;
        this.isCheck =isCheck;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
