package com.example.yuan.modle;

public class Communction {

    private int communction_id;//消息记录编号
    private String communction_user;//用户
    private String communction_head;//项目分责人
   private String communctions;//消息
  private String communction_isAccept;//消息接收状态
    private String communction_time;//发消息的时间

    public Communction(){}
    public Communction(int communction_id, String communction_user, String communction_head, String administrator_name, String administrator_password, String administrator_telephone){
        super();
    }

    public String getCommunction_user() {
        return communction_user;
    }

    public void setCommunction_user(String communction_user) {
        this.communction_user = communction_user;
    }

    public String getCommunction_head() {
        return communction_head;
    }

    public void setCommunction_head(String communction_head) {
        this.communction_head = communction_head;
    }

    public int getCommunction_id() {
        return communction_id;
    }

    public void setCommunction_id(int communction_id) {
        this.communction_id = communction_id;
    }

    public String getCommunctions() {
        return communctions;
    }

    public void setCommunctions(String communctions) {
        this.communctions = communctions;
    }

    public String isCommunction_isAccept() {
        return communction_isAccept;
    }

    public void setCommunction_isAccept(String communction_isAccept) {
        this.communction_isAccept = communction_isAccept;
    }

    public String getCommunction_time() {
        return communction_time;
    }

    public void setCommunction_time(String communction_time) {
        this.communction_time = communction_time;
    }
}
