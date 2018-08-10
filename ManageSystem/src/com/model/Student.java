package com.model;

import java.sql.Date;

/**
 *  学生类
 */
public class Student {
    private String user;//学生用户名
    private String pwd;//密码
    private String name;//学生姓名
    private String phone;//学生手机号
    private String major;//学生所在专业
    private Integer classroom;//学生所在班级
    private Integer serial;//学生班内序号
    private Date entranceTime;//入学时间

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

    public void setUser(String user) {
        this.user = user;
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
