package com.model;

/**
 *  成绩类
 */

public class Grade {
    private String user;//学生学号
    private Integer math;//数学成绩
    private Integer english;//英语成绩
    private Integer cProgram;//C语言成绩
    private Integer sum;//总成绩
    private Integer point;//绩点

    public Grade() {
    }

    public String getUser() {
        return user;
    }

    public Integer getMath() {
        return math;
    }

    public Integer getEnglish() {
        return english;
    }

    public Integer getcProgram() {
        return cProgram;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getPoint() {
        return point;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public void setcProgram(Integer cProgram) {
        this.cProgram = cProgram;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
