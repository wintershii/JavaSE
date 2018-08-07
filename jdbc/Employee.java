package jdbc;

import java.sql.Date;

public class Employee {     //表结构和类对应
    private Integer id;
    private String empname;
    private Double salary;
    private Date hireDate;
    private Integer age;
    private Integer departId;

    public Employee(String empname, Double salary, Date hireDate, Integer age, Integer departId) {
        this.empname = empname;
        this.salary = salary;
        this.hireDate = hireDate;
        this.age = age;
        this.departId = departId;
    }

    public Employee(Integer id, String empname, Double salary, Date hireDate, Integer age, Integer departId) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.hireDate = hireDate;
        this.age = age;
        this.departId = departId;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmpname() {
        return empname;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }
}
