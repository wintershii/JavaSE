package com.model;

/**
 *  教师类
 */
public class Teacher {
    private String user;//教师用户名
    private String pwd;//密码
    private String name;//教师姓名
    private String phone;//教师手机号
    private String major;//教师专业
    private String subject;//教师所在科目

    public Teacher() {
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

    public String getSubject() {
        return subject;
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

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
