package com.example.yuan.modle;

import java.sql.Blob;

public class Effect {
    private int effect_id;//	效果图编号
    private String effect_name;//	效果图名
    private String effect_stytle;//	效果图风格
    private String effect_area;    //效果图面积
    private String effect_type;    //效果图户型
    private String effect_keting;//客厅图片路径
    private String effect_woshi;//卧室图片路径
    private String effect_shufang;//书房图片路径
    private String effect_canting;//餐厅图片路径
    private String effect_weishengjian;//卫生间图片路径
    private String effect_qita;//其他图片路径
    private String effect_ketingDes;//客厅图片描述
    private String effect_woshiDes;//卧室图片描述
    private String effect_shufangDes;//书房图片描述
    private String effect_cantingDes;//餐厅图片描述
    private String effect_weishengjianDes;//卫生间图片描述
    private String effect_qitaDes;//其他图片描述
    private String effect_recommand;    //是否推荐
    private String effect_UserSee;    //是否对用户可见
    private String effect_PriceOne;    //第一阶段价格
    private String effect_PriceTwo;    //第二阶段价格
    private String effect_PriceThree;//	第三阶段价格
    private String effect_PriceFour;    //第四阶段价格
    private String effect_PriceFive;    //第五阶段价格
    private String effect_PriceSum;//	效果图预算总价

public Effect(){}
    public Effect(int effect_id, String effect_name, String effect_stytle, String effect_area,String effect_type,
                   String effect_keting, String effect_woshi, String effect_shufang, String effect_canting,
                  String effect_weishengjian, String effect_qita,
                  String effect_ketingDes, String effect_woshiDes, String effect_shufangDes, String effect_cantingDes,
                  String effect_weishengjianDes, String effect_qitaDes,
                  String effect_recommand, String effect_UserSee, String effect_PriceOne, String effect_PriceTwo,
                  String effect_PriceThree, String effect_PriceFour, String effect_PriceFive, String effect_PriceSum) {
    super();
        this.effect_id = effect_id;
        this.effect_name = effect_name;
        this.effect_stytle = effect_stytle;
        this.effect_area = effect_area;
        this.effect_type = effect_type;
        this.effect_keting = effect_keting;
        this.effect_woshi = effect_woshi;
        this.effect_shufang = effect_shufang;
        this.effect_canting = effect_canting;
        this.effect_weishengjian = effect_weishengjian;
        this.effect_qita = effect_qita;
        this.effect_ketingDes = effect_ketingDes;
        this.effect_woshiDes = effect_woshiDes;
        this.effect_shufangDes = effect_shufangDes;
        this.effect_cantingDes = effect_cantingDes;
        this.effect_weishengjianDes = effect_weishengjianDes;
        this.effect_qitaDes = effect_qitaDes;
        this.effect_recommand = effect_recommand;
        this.effect_UserSee = effect_UserSee;
        this.effect_PriceOne = effect_PriceOne;
        this.effect_PriceTwo = effect_PriceTwo;
        this.effect_PriceThree = effect_PriceThree;
        this.effect_PriceFour = effect_PriceFour;
        this.effect_PriceFive = effect_PriceFive;
        this.effect_PriceSum = effect_PriceSum;
    }

    public int getEffect_id() {
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

    public String getEffect_area() {
        return effect_area;
    }

    public void setEffect_area(String effect_area) {
        this.effect_area = effect_area;
    }

    public String getEffect_type() {
        return effect_type;
    }

    public void setEffect_type(String effect_type) {
        this.effect_type = effect_type;
    }

    public String getEffect_ketingDes() {
        return effect_ketingDes;
    }

    public void setEffect_ketingDes(String effect_ketingDes) {
        this.effect_ketingDes = effect_ketingDes;
    }

    public String getEffect_woshiDes() {
        return effect_woshiDes;
    }

    public void setEffect_woshiDes(String effect_woshiDes) {
        this.effect_woshiDes = effect_woshiDes;
    }

    public String getEffect_shufangDes() {
        return effect_shufangDes;
    }

    public void setEffect_shufangDes(String effect_shufangDes) {
        this.effect_shufangDes = effect_shufangDes;
    }

    public String getEffect_cantingDes() {
        return effect_cantingDes;
    }

    public void setEffect_cantingDes(String effect_cantingDes) {
        this.effect_cantingDes = effect_cantingDes;
    }

    public String getEffect_weishengjianDes() {
        return effect_weishengjianDes;
    }

    public void setEffect_weishengjianDes(String effect_weishengjianDes) {
        this.effect_weishengjianDes = effect_weishengjianDes;
    }

    public String getEffect_qitaDes() {
        return effect_qitaDes;
    }

    public void setEffect_qitaDes(String effect_qitaDes) {
        this.effect_qitaDes = effect_qitaDes;
    }

    public String getEffect_keting() {
        return effect_keting;
    }

    public void setEffect_keting(String effect_keting) {
        this.effect_keting = effect_keting;
    }

    public String getEffect_woshi() {
        return effect_woshi;
    }

    public void setEffect_woshi(String effect_woshi) {
        this.effect_woshi = effect_woshi;
    }

    public String getEffect_shufang() {
        return effect_shufang;
    }

    public void setEffect_shufang(String effect_shufang) {
        this.effect_shufang = effect_shufang;
    }

    public String getEffect_canting() {
        return effect_canting;
    }

    public void setEffect_canting(String effect_canting) {
        this.effect_canting = effect_canting;
    }

    public String getEffect_weishengjian() {
        return effect_weishengjian;
    }

    public void setEffect_weishengjian(String effect_weishengjian) {
        this.effect_weishengjian = effect_weishengjian;
    }

    public String getEffect_qita() {
        return effect_qita;
    }

    public void setEffect_qita(String effect_qita) {
        this.effect_qita = effect_qita;
    }

    public String isEffect_recommand() {
        return effect_recommand;
    }

    public void setEffect_recommand(String effect_recommand) {
        this.effect_recommand = effect_recommand;
    }

    public String isEffect_UserSee() {
        return effect_UserSee;
    }

    public void setEffect_UserSee(String effect_UserSee) {
        this.effect_UserSee = effect_UserSee;
    }

    public String getEffect_PriceOne() {
        return effect_PriceOne;
    }

    public void setEffect_PriceOne(String effect_PriceOne) {
        this.effect_PriceOne = effect_PriceOne;
    }

    public String getEffect_PriceTwo() {
        return effect_PriceTwo;
    }

    public void setEffect_PriceTwo(String effect_PriceTwo) {
        this.effect_PriceTwo = effect_PriceTwo;
    }

    public String getEffect_PriceThree() {
        return effect_PriceThree;
    }

    public void setEffect_PriceThree(String effect_PriceThree) {
        this.effect_PriceThree = effect_PriceThree;
    }

    public String getEffect_PriceFour() {
        return effect_PriceFour;
    }

    public void setEffect_PriceFour(String effect_PriceFour) {
        this.effect_PriceFour = effect_PriceFour;
    }

    public String getEffect_PriceFive() {
        return effect_PriceFive;
    }

    public void setEffect_PriceFive(String effect_PriceFive) {
        this.effect_PriceFive = effect_PriceFive;
    }

    public String getEffect_PriceSum() {
        return effect_PriceSum;
    }

    public void setEffect_PriceSum(String effect_PriceSum) {
        this.effect_PriceSum = effect_PriceSum;
    }


}