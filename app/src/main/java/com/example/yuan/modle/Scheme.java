package com.example.yuan.modle;

public class Scheme {
    private int scheme_id;//	方案编号
    private String scheme_houseType;//	户型
    private String scheme_houseArea;//	面积
    private String scheme_houseStyle;//	风格
    private String scheme_pirceOne;//	第一阶段工钱
    private String scheme_pirceTwoWork;//	第二阶段工钱
    private String scheme_pirceTwoMaterial;//	第二阶段材料材料钱
    private String scheme_pirceThreeWork;//	第三阶段材料工钱
    private String scheme_pirceThreeMaterial;//第三阶段材料材料钱
    private String scheme_pirceFourWork;//	第四阶段材料工钱
    private String scheme_pirceFourMaterial;//	第四阶段材料材料钱
    private String scheme_pirceFivework;//第五阶段材料工钱
    private String scheme_pirceFiveMaterial;//	第五阶段材料材料钱
    private String scheme_pirceSum;//	总价
    public  Scheme(){}
    public  Scheme(String scheme_houseType, String scheme_houseArea, String scheme_houseStyle, String scheme_pirceOne, String scheme_pirceTwoWork, String scheme_pirceTwoMaterial, String scheme_pirceThreeWork, String scheme_pirceThreeMaterial, String scheme_pirceFourWork, String scheme_pirceFourMaterial, String scheme_pirceFivework, String scheme_pirceFiveMaterial, String scheme_pirceSum){}
    public Scheme(int scheme_id, String scheme_houseType, String scheme_houseArea, String scheme_houseStyle, String scheme_pirceOne, String scheme_pirceTwoWork, String scheme_pirceTwoMaterial, String scheme_pirceThreeWork, String scheme_pirceThreeMaterial, String scheme_pirceFourWork, String scheme_pirceFourMaterial, String scheme_pirceFivework, String scheme_pirceFiveMaterial, String scheme_pirceSum){}


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

    public String getScheme_houseArea() {
        return scheme_houseArea;
    }

    public void setScheme_houseArea(String scheme_houseArea) {
        this.scheme_houseArea = scheme_houseArea;
    }
    public String getScheme_pirceTwoMaterial() {
        return scheme_pirceTwoMaterial;
    }

    public void setScheme_pirceTwoMaterial(String scheme_pirceTwoMaterial) {
        this.scheme_pirceTwoMaterial = scheme_pirceTwoMaterial;
    }
    public String getScheme_houseStyle() {
        return scheme_houseStyle;
    }

    public void setScheme_houseStyle(String scheme_houseStyle) {
        this.scheme_houseStyle = scheme_houseStyle;
    }

    public String getScheme_pirceOne() {
        return scheme_pirceOne;
    }

    public void setScheme_pirceOne(String scheme_pirceOne) {
        this.scheme_pirceOne = scheme_pirceOne;
    }

    public String getScheme_pirceTwoWork() {
        return scheme_pirceTwoWork;
    }

    public void setScheme_pirceTwoWork(String scheme_pirceTwoWork) {
        this.scheme_pirceTwoWork = scheme_pirceTwoWork;
    }



    public String getScheme_pirceThreeWork() {
        return scheme_pirceThreeWork;
    }

    public void setScheme_pirceThreeWork(String scheme_pirceThreeWork) {
        this.scheme_pirceThreeWork = scheme_pirceThreeWork;
    }

    public String getScheme_pirceThreeMaterial() {
        return scheme_pirceThreeMaterial;
    }

    public void setScheme_pirceThreeMaterial(String scheme_pirceThreeMaterial) {
        this.scheme_pirceThreeMaterial = scheme_pirceThreeMaterial;
    }

    public String getScheme_pirceFourWork() {
        return scheme_pirceFourWork;
    }

    public void setScheme_pirceFourWork(String scheme_pirceFourWork) {
        this.scheme_pirceFourWork = scheme_pirceFourWork;
    }

    public String getScheme_pirceFourMaterial() {
        return scheme_pirceFourMaterial;
    }

    public void setScheme_pirceFourMaterial(String scheme_pirceFourMaterial) {
        this.scheme_pirceFourMaterial = scheme_pirceFourMaterial;
    }

    public String getScheme_pirceFivework() {
        return scheme_pirceFivework;
    }

    public void setScheme_pirceFivework(String scheme_pirceFivework) {
        this.scheme_pirceFivework = scheme_pirceFivework;
    }

    public String getScheme_pirceFiveMaterial() {
        return scheme_pirceFiveMaterial;
    }

    public void setScheme_pirceFiveMaterial(String scheme_pirceFiveMaterial) {
        this.scheme_pirceFiveMaterial = scheme_pirceFiveMaterial;
    }

    public String getScheme_pirceSum() {
        return scheme_pirceSum;
    }

    public void setScheme_pirceSum(String scheme_pirceSum) {
        this.scheme_pirceSum = scheme_pirceSum;
    }
}