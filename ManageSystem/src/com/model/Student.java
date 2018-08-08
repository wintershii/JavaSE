package com.model;

import java.sql.Date;

public class Student {
    private String user;
    private String pwd;
    private String name;
    private String phone;
    private String major;
    private Integer classroom;
    private Integer serial;
    private Date entranceTime;

    public Student() {
    }

    public Student(String user, String pwd, String name, String phone, String major, Integer classroom) {
        this.user = user;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.major = major;
        this.classroom = classroom;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMajor() {
        return major;
    }

    public Integer getClassroom() {
        return classroom;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }
}
