package com.example.yuan.modle;

public class Scheme {
    private int scheme_id;//	方案编号
    private String scheme_houseType;//	户型
    private double scheme_houseArea;//	面积
    private String scheme_houseStyle;//	风格
    private double scheme_pirceOne;//	第一阶段工钱
    private double scheme_pirceTwoWork;//	第二阶段工钱
    private double scheme_pirceTwoMaterial;//	第二阶段材料材料钱
    private double scheme_pirceThreeWork;//	第三阶段材料工钱
    private double scheme_pirceThreeMaterial;//第三阶段材料材料钱
    private double scheme_pirceFourWork;//	第四阶段材料工钱
    private double scheme_pirceFourMaterial;//	第四阶段材料材料钱
    private double scheme_pirceFivework;//第五阶段材料工钱
    private double scheme_pirceFiveMaterial;//	第五阶段材料材料钱
    private double scheme_pirceSum;//	总价

    public Scheme(int scheme_id, String scheme_houseType, String scheme_houseArea, String scheme_houseStyle, String scheme_pirceOne, String scheme_pirceTwoWork, String scheme_pirceTwoMaterial, String scheme_pirceThreeWork, String scheme_pirceThreeMaterial, String scheme_pirceFourWork, String scheme_pirceFourMaterial, String scheme_pirceFivework, String scheme_pirceFiveMaterial, String scheme_pirceSum){}
    public Scheme(String effect_name, double effect_stytle, String effect_area, double effect_type, double effect_describe, double effect_photo, double effect_recommand, double effect_userSee, double effect_priceOne, double effect_priceTwo, double effect_priceThree, double effect_priceFour, double effect_priceFive, int effect_priceSum) {
        super();
    }

    public int getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(int scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getScheme_houseType() {
        return scheme_houseType;
    }

    public void setScheme_houseType(String scheme_houseType) {
        this.scheme_houseType = scheme_houseType;
    }

    public double getScheme_houseArea() {
        return scheme_houseArea;
    }

    public void setScheme_houseArea(double scheme_houseArea) {
        this.scheme_houseArea = scheme_houseArea;
    }

    public String getScheme_houseStyle() {
        return scheme_houseStyle;
    }

    public void setScheme_houseStyle(String scheme_houseStyle) {
        this.scheme_houseStyle = scheme_houseStyle;
    }

    public double getScheme_pirceOne() {
        return scheme_pirceOne;
    }

    public void setScheme_pirceOne(double scheme_pirceOne) {
        this.scheme_pirceOne = scheme_pirceOne;
    }

    public double getScheme_pirceTwoWork() {
        return scheme_pirceTwoWork;
    }

    public void setScheme_pirceTwoWork(double scheme_pirceTwoWork) {
        this.scheme_pirceTwoWork = scheme_pirceTwoWork;
    }

    public double getScheme_pirceTwoMaterial() {
        return scheme_pirceTwoMaterial;
    }

    public void setScheme_pirceTwoMaterial(double scheme_pirceTwoMaterial) {
        this.scheme_pirceTwoMaterial = scheme_pirceTwoMaterial;
    }

    public double getScheme_pirceThreeWork() {
        return scheme_pirceThreeWork;
    }

    public void setScheme_pirceThreeWork(double scheme_pirceThreeWork) {
        this.scheme_pirceThreeWork = scheme_pirceThreeWork;
    }

    public double getScheme_pirceThreeMaterial() {
        return scheme_pirceThreeMaterial;
    }

    public void setScheme_pirceThreeMaterial(double scheme_pirceThreeMaterial) {
        this.scheme_pirceThreeMaterial = scheme_pirceThreeMaterial;
    }

    public double getScheme_pirceFourWork() {
        return scheme_pirceFourWork;
    }

    public void setScheme_pirceFourWork(double scheme_pirceFourWork) {
        this.scheme_pirceFourWork = scheme_pirceFourWork;
    }

    public double getScheme_pirceFourMaterial() {
        return scheme_pirceFourMaterial;
    }

    public void setScheme_pirceFourMaterial(double scheme_pirceFourMaterial) {
        this.scheme_pirceFourMaterial = scheme_pirceFourMaterial;
    }

    public double getScheme_pirceFivework() {
        return scheme_pirceFivework;
    }

    public void setScheme_pirceFivework(double scheme_pirceFivework) {
        this.scheme_pirceFivework = scheme_pirceFivework;
    }

    public double getScheme_pirceFiveMaterial() {
        return scheme_pirceFiveMaterial;
    }

    public void setScheme_pirceFiveMaterial(double scheme_pirceFiveMaterial) {
        this.scheme_pirceFiveMaterial = scheme_pirceFiveMaterial;
    }

    public double getScheme_pirceSum() {
        return scheme_pirceSum;
    }

    public void setScheme_pirceSum(double scheme_pirceSum) {
        this.scheme_pirceSum = scheme_pirceSum;
    }
}