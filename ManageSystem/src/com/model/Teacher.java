package com.model;

public class Teacher {
    private String user;
    private String pwd;
    private String name;
    private String phone;
    private String major;
    private String subject;

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
