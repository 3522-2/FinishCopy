package com.example.yuan.modle;


public class HongBao {

    private String hong_name;//用户名
    private String hong_thou;//1000员优惠卷
    private String hong_three;//300优惠卷
    private String hong_nametel;//参与活动的用户电话号码

    public HongBao() {
        super();
    }


    public HongBao(String hong_name, String hong_thou, String hong_three, String hong_nametel) {
        super();
        this.hong_name = hong_name;
        this.hong_thou = hong_thou;
        this.hong_three = hong_three;
        this.hong_nametel = hong_nametel;

    }

    public HongBao(String hong_thou, String hong_three, String hong_name) {
        super();
        this.hong_name = hong_name;
        this.hong_thou = hong_thou;
        this.hong_three = hong_three;
    }

    public String getHong_name() {
        return hong_name;
    }

    public void setHong_name(String hong_name) {
        this.hong_name = hong_name;
    }

    public String getHong_thou() {
        return hong_thou;
    }

    public void setHong_thou(String hong_thou) {
        this.hong_thou = hong_thou;
    }

    public String getHong_three() {
        return hong_three;
    }

    public void setHong_three(String hong_three) {
        this.hong_three = hong_three;
    }

    public String getHong_nametel() {
        return hong_nametel;
    }

    public void setHong_nametel(String hong_nametel) {
        this.hong_nametel = hong_nametel;
    }
}

