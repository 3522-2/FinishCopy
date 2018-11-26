package com.example.yuan.modle;

public class Information {
    private int information_id;//用户信息编号
    private String information_user;//	用户名
    private String information_userTelephon;//	用户电话
    private String information_address;//	地址（小区，房间号）
    private double information_Area;//	面积
    private String information_Type;//	户型
    private String information_Stytle;//	要求风格

    public Information(int information_id, String information_user, String information_userTelephon, String information_address, String information_Area, String information_Type, String information_Stytle){}
    public Information(int information_id, String aDouble, String string, String cursorDouble, double information_area, String cursorString, String s){
        super();
    }

    public int getInformation_id() {
        return information_id;
    }

    public void setInformation_id(int information_id) {
        this.information_id = information_id;
    }

    public String getInformation_user() {
        return information_user;
    }

    public void setInformation_user(String information_user) {
        this.information_user = information_user;
    }

    public String getInformation_userTelephon() {
        return information_userTelephon;
    }

    public void setInformation_userTelephon(String information_userTelephon) {
        this.information_userTelephon = information_userTelephon;
    }

    public String getInformation_address() {
        return information_address;
    }

    public void setInformation_address(String information_address) {
        this.information_address = information_address;
    }

    public double getInformation_Area() {
        return information_Area;
    }

    public void setInformation_Area(double information_Area) {
        this.information_Area = information_Area;
    }

    public String getInformation_Type() {
        return information_Type;
    }

    public void setInformation_Type(String information_Type) {
        this.information_Type = information_Type;
    }

    public String getInformation_Stytle() {
        return information_Stytle;
    }

    public void setInformation_Stytle(String information_Stytle) {
        this.information_Stytle = information_Stytle;
    }
}
