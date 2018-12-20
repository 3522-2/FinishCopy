package com.example.yuan.modle;



public class Project {
    private String project_id;	//项目阶段编号
    private String project_Name;//项目阶段
    private String project_StartTime;	//阶段开始时间
    private String project_FinishTime;	//阶段结束时间
    private String project_photo;//	阶段后施工后效果图
    private String project_principle;//	阶段负责人
    private String project_UserEvaluation;//	用户评价
    private String project_UserAcceptance;//	用户验收
    private String project_address;//	用户地址（精确到房间号）
    private String project_Des;//	进度描述
    public Project(){super();}

    public Project(String project_id, String project_Name, String project_StartTime, String project_FinishTime,String project_photo, String project_principle, String project_UserEvaluation, String project_UserAcceptance, String project_address, String project_Des) {
        super();
        this.project_id = project_id;
        this.project_Name = project_Name;
        this.project_photo = project_photo;
        this.project_StartTime = project_StartTime;
        this.project_FinishTime = project_FinishTime;
        this.project_Des = project_Des;
        this.project_principle = project_principle;
        this.project_UserEvaluation = project_UserEvaluation;
        this.project_UserAcceptance = project_UserAcceptance;

        this.project_address = project_address;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }

    public String getProject_StartTime() {
        return project_StartTime;
    }

    public void setProject_StartTime(String project_StartTime) {
        this.project_StartTime = project_StartTime;
    }

    public String getProject_FinishTime() {
        return project_FinishTime;
    }

    public void setProject_FinishTime(String project_FinishTime) {
        this.project_FinishTime = project_FinishTime;
    }

    public String getProject_photo() {
        return project_photo;
    }

    public void setProject_photo(String project_photo) {
        this.project_photo = project_photo;
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

    public String getProject_Des() {
        return project_Des;
    }

    public void setProject_Des(String project_Des) {
        this.project_Des = project_Des;
    }
}
