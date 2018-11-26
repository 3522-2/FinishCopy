package com.example.yuan.modle;

import java.sql.Blob;

public class Effect {
    private int effect_id;//	效果图编号
    private String effect_name;//	效果图名
    private String effect_stytle;//	效果图风格
    private double effect_area;	//效果图面积
    private String effect_type;	//效果图户型
    private String effect_describe;	//效果图描述
    private String effect_photo;	//图片
   private boolean effect_recommand;	//是否推荐
   private boolean effect_UserSee;	//是否对用户可见
    private double effect_PriceOne;	//第一阶段价格
    private double effect_PriceTwo;	//第二阶段价格
    private double effect_PriceThree;//	第三阶段价格
    private double effect_PriceFour;	//第四阶段价格
    private double effect_PriceFive;	//第五阶段价格
    private double effect_PriceSum;//	效果图预算总价

    public Effect(int effect_id, String effect_name, String effect_stytle, String effect_area, String effect_type, String effect_describe, byte[] effect_photo, String effect_recommand, String effect_UserSee, String effect_PriceOne, String effect_PriceTwo, String effect_PriceThree, String effect_PriceFour, String effect_PriceFive, String effect_PriceSum){}
    public Effect(int anInt, double aDouble, String string,
                  int cursorInt, double cursorDouble,
                  String cursorString, int i, double v, String s,
                  int anInt1, double aDouble1,
                  String effect_priceFour, String string1, String cursorString1) {

    }

    public Effect(int effect_id, String effect_name, String effect_stytle, double effect_area, String effect_type, String effect_describe, byte[] effect_photos, String effect_recommand, String effect_userSee, double effect_priceOne, double effect_priceTwo, double effect_priceThree, double effect_priceFour, double effect_priceFive, double effect_priceSum) {
    }

    public int  getEffect_id() {
        return effect_id;
    }

    public void setEffect_id(int effect_id) {
        this.effect_id = effect_id;
    }

    public String getEffect_name() {
        return effect_name;
    }

    public void setEffect_name(String effect_name) {
        this.effect_name = effect_name;
    }

    public String getEffect_stytle() {
        return effect_stytle;
    }

    public void setEffect_stytle(String effect_stytle) {
        this.effect_stytle = effect_stytle;
    }

    public double getEffect_area() {
        return effect_area;
    }

    public void setEffect_area(double effect_area) {
        this.effect_area = effect_area;
    }

    public String getEffect_type() {
        return effect_type;
    }

    public void setEffect_type(String effect_type) {
        this.effect_type = effect_type;
    }

    public String getEffect_describe() {
        return effect_describe;
    }

    public void setEffect_describe(String effect_describe) {
        this.effect_describe = effect_describe;
    }

    public String getEffect_photo() {
        return effect_photo;
    }

    public void setEffect_photo(String effect_photo) {
        this.effect_photo = effect_photo;
    }

    public boolean getEffect_recommand() {
        return effect_recommand;
    }

    public void setEffect_recommand(boolean effect_recommand) {
        this.effect_recommand = effect_recommand;
    }

    public boolean getEffect_UserSee() {
        return effect_UserSee;
    }

    public void setEffect_UserSee(boolean effect_UserSee) {
        this.effect_UserSee = effect_UserSee;
    }

    public double getEffect_PriceOne() {
        return effect_PriceOne;
    }

    public void setEffect_PriceOne(double effect_PriceOne) {
        this.effect_PriceOne = effect_PriceOne;
    }

    public double getEffect_PriceTwo() {
        return effect_PriceTwo;
    }

    public void setEffect_PriceTwo(double effect_PriceTwo) {
        this.effect_PriceTwo = effect_PriceTwo;
    }

    public double getEffect_PriceThree() {
        return effect_PriceThree;
    }

    public void setEffect_PriceThree(double effect_PriceThree) {
        this.effect_PriceThree = effect_PriceThree;
    }

    public double getEffect_PriceFour() {
        return effect_PriceFour;
    }

    public void setEffect_PriceFour(double effect_PriceFour) {
        this.effect_PriceFour = effect_PriceFour;
    }

    public double getEffect_PriceFive() {
        return effect_PriceFive;
    }

    public void setEffect_PriceFive(double effect_PriceFive) {
        this.effect_PriceFive = effect_PriceFive;
    }

    public double getEffect_PriceSum() {
        return effect_PriceSum;
    }

    public void setEffect_PriceSum(double effect_PriceSum) {
        this.effect_PriceSum = effect_PriceSum;
    }
}
