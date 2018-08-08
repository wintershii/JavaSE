package com.model;

public class Grade {
    private String user;
    private Integer math;
    private Integer english;
    private Integer cProgram;
    private Integer sum;
    private Integer point;

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
