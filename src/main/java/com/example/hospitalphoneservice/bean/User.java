package com.example.hospitalphoneservice.bean;

public class User {

    private String sname;
    private String staffid;
    private String sjobnum;
    private String collect;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getSjobnum() {
        return sjobnum;
    }

    public void setSjobnum(String sjobnum) {
        this.sjobnum = sjobnum;
    }
}
