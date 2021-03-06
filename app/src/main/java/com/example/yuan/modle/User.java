package com.example.yuan.modle;

public class User {

    private  int user_id;//	用户号
    private String user_name;//	用户名
    private String user_password;//	用户密码
    private String user_telephone;//	用户电话
    private String user_adr;//	用户地址
    private String user_houseType;//	用户户型
    private String user_houseArea;//	房屋面积
    private String user_touxiang;//	房屋面积

    public User(){
        super();
    };

    public User(int user_id, String user_name, String user_password,
                String user_telephone,String user_adr,String user_houseType,
                String user_touxiang, String user_houseArea){
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_telephone = user_telephone;
        this.user_adr = user_adr;
        this.user_houseType = user_houseType;
        this.user_touxiang = user_touxiang;
        this.user_houseArea = user_houseArea;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_telephone() {
        return user_telephone;
    }

    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }

    public String getUser_adr() {
        return user_adr;
    }

    public void setUser_adr(String user_adr) {
        this.user_adr = user_adr;
    }

    public String getUser_houseType() {
        return user_houseType;
    }

    public void setUser_houseType(String user_houseType) {
        this.user_houseType = user_houseType;
    }

    public String getUser_houseArea() {
        return user_houseArea;
    }

    public void setUser_houseArea(String user_houseArea) {
        this.user_houseArea = user_houseArea;
    }

    public String getUser_touxiang() {
        return user_touxiang;
    }

    public void setUser_touxiang(String user_touxiang) {
        this.user_touxiang = user_touxiang;
    }
}
