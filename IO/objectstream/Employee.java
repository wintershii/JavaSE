package com.io.objectstream;

/**
 *
 * 空接口只是标识
 */
public class Employee implements java.io.Serializable{
    private transient String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){
        return "薪水"+this.salary;
    }
}
