package com.collection.sort;

public class Worker implements java.lang.Comparable<Worker>{
    private String type;
    private double salary;

    public Worker() {
    }

    public Worker(String type, double salary) {
        this.type = type;
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public double getSalary() {
        return salary;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 按工资升序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Worker o) {
        return this.salary > o.salary ? 1 : (this.salary == o.salary)? 0 : -1;
    }

    public String toString(){
        return "职位：" + this.type + "薪水："+this.salary;
    }
}
