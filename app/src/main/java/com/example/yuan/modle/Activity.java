package com.example.yuan.modle;

public class Activity {
    private String activity_id;//优惠活动编号
    private String activity_name;//活动名

    private String activity_content;//活动内容
    private String activity_UserName;//参与活动的用户名
    private String activity_Thou;//1000员优惠卷
    private String activity_Three;//300优惠卷
    private String activity_UserNameTel;//参与活动的用户电话号码
    public Activity(){super();}

    public Activity(String activity_id,String activity_name,String activity_UserName, String activity_Thou, String activity_Three){
        super();
        this.activity_id = activity_id;
        this.activity_name=activity_name;
        this.activity_UserName=activity_UserName;
        this.activity_Thou=activity_Thou;
        this.activity_Three=activity_Three;
    }

    public Activity(String activity_id, String activity_name, String activity_UserName,
                    String activity_content, String activity_Thou, String activity_Three){
        super();
        this.activity_id = activity_id;
        this.activity_name=activity_name;
        this.activity_UserName=activity_UserName;

        this.activity_content=activity_content;
        this.activity_Thou=activity_Thou;
        this.activity_Three=activity_Three;

    }

    public String getActivity_UserNameTel() {
        return activity_UserNameTel;
    }

    public void setActivity_UserNameTel(String activity_UserNameTel) {
        this.activity_UserNameTel = activity_UserNameTel;
    }

    public String getActivity_Thou() {
        return activity_Thou;
    }

    public void setActivity_Thou(String activity_Thou) {
        this.activity_Thou = activity_Thou;
    }

    public String getActivity_Three() {
        return activity_Three;
    }

    public void setActivity_Three(String activity_Three) {
        this.activity_Three = activity_Three;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public String getActivity_UserName() {
        return activity_UserName;
    }

    public void setActivity_UserName(String activity_UserName) {
        this.activity_UserName = activity_UserName;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }



    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }
}
