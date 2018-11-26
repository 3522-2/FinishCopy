package com.example.yuan.modle;

import java.sql.Blob;

public class Project {
    private int project_id;	//项目阶段编号
    private double project_StartTime;	//阶段开始时间
    private double project_FinishTime;	//阶段结束时间
    private String proiect_photo;//	阶段后施工后效果图
    private String project_principle;//	阶段负责人
    private String project_UserEvaluation;//	用户评价
    private String project_UserAcceptance;//	用户验收
    private String project_address;//	用户地址（精确到房间号）

    public Project(int project_id, String project_StartTime, String project_FinishTime, String proiect_photo, String project_principle, String project_UserEvaluation, String project_UserAcceptance, String project_address){}
    public Project(int administrator_id, double administrator_name, double administrator_password, byte[] administrator_telephone, String administratorId, String administratorName, String administratorPassword, String administratorTelephone){
        super();
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public double getProject_StartTime() {
        return project_StartTime;
    }

    public void setProject_StartTime(double project_StartTime) {
        this.project_StartTime = project_StartTime;
    }

    public double getProject_FinishTime() {
        return project_FinishTime;
    }

    public void setProject_FinishTime(double project_FinishTime) {
        this.project_FinishTime = project_FinishTime;
    }

    public String getProiect_photo() {
        return proiect_photo;
    }

    public void setProiect_photo(String proiect_photo) {
        this.proiect_photo = proiect_photo;
    }

    public String getProject_principle() {
        return project_principle;
    }

    public void setProject_principle(String project_principle) {
        this.project_principle = project_principle;
    }

    public String getProject_UserEvaluation() {
        return project_UserEvaluation;
    }

    public void setProject_UserEvaluation(String project_UserEvaluation) {
        this.project_UserEvaluation = project_UserEvaluation;
    }

    public String getProject_UserAcceptance() {
        return project_UserAcceptance;
    }

    public void setProject_UserAcceptance(String project_UserAcceptance) {
        this.project_UserAcceptance = project_UserAcceptance;
    }

    public String getProject_address() {
        return project_address;
    }

    public void setProject_address(String project_address) {
        this.project_address = project_address;
    }
}
