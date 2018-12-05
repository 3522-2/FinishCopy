package com.example.yuan;

import android.graphics.drawable.Drawable;

/**
 * Created by lenovo on 2018/12/2.
 */

public class Board {
    private String name;
    private int picture;
    public Board(String name,int picture){
        this.name=name;
        this.picture=picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
