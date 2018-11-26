package com.example.yuan.modle;

public class Administrator {
    private int administrator_id;//管理员编号
    private String administrator_name;//管理员姓名
    private String administrator_password;//管理员密码
    private String administrator_telephone;//管理员手机号

    public Administrator(){}
    public Administrator(int administrator_id, String administrator_name, String administrator_password, String administrator_telephone){
        super();
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getAdministrator_name() {
        return administrator_name;
    }

    public void setAdministrator_name(String administrator_name) {
        this.administrator_name = administrator_name;
    }

    public String getAdministrator_password() {
        return administrator_password;
    }

    public void setAdministrator_password(String administrator_password) {
        this.administrator_password = administrator_password;
    }

    public String getAdministrator_telephone() {
        return administrator_telephone;
    }

    public void setAdministrator_telephone(String administrator_telephone) {
        this.administrator_telephone = administrator_telephone;
    }
}
