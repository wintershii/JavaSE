package com.model;

/**
 * 管理员类
 */
public class Manager {
    private String user;//用户名
    private String pwd;//密码
    private String name;//管理员姓名
    private String phone;//管理员手机号

    public Manager() {
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
}
