package com.collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;
    private Date hireDate;

    public Employee(int id, String name, int salary, String department, String strDate)  {  //javabean 实体类
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;

        DateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            this.hireDate = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Employee(){

    }
    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
