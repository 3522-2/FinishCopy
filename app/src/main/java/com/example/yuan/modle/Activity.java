package com.example.yuan.modle;

public class Activity {
    private int activity_id;//优惠活动编号
    private String activity_name;//活动名
    private String activity_StartTime;//活动开始时间
    private String activity_FinishTime;//活动结束时间
    private String activity_people;//参与对象
    private String activity_content;//活动内容
    public  Activity(int activity_id, String activity_name, String activity_StartTime, String activity_FinishTime, String activity_people, String activity_content){

    }

    public  Activity(int id, double money, String time, String type){
        super();
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_StartTime() {
        return activity_StartTime;
    }

    public void setActivity_StartTime(String activity_StartTime) {
        this.activity_StartTime = activity_StartTime;
    }

    public String getActivity_FinishTime() {
        return activity_FinishTime;
    }

    public void setActivity_FinishTime(String activity_FinishTime) {
        this.activity_FinishTime = activity_FinishTime;
    }

    public String getActivity_people() {
        return activity_people;
    }

    public void setActivity_people(String activity_people) {
        this.activity_people = activity_people;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }
}
