package com.jdbc.model;
;
import java.sql.Date;

public class Employee {

    private int id;
    private String surName;
    private String job;
    private Date hireDate;
    private float salary;
    private float commission;
    private int managerId;
    private int departmentId;
    private Department department = new Department();
    private SalGrade salGrade = new SalGrade();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SalGrade getSalGrade() {
        return salGrade;
    }

    public void setSalGrade(SalGrade salGrade) {
        this.salGrade = salGrade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + id +
                ", eName='" + surName + '\'' +
                ", job='" + job + '\'' +
                ", hireDate=" + hireDate +
                ", sal=" + salary +
                ", comm=" + commission +
                ", mgr=" + managerId +
                ", deptNo=" + departmentId +
                ", grade=" + salGrade.getGrade() +
                ", depLocation='" + department.getLoc() + '\'' +
                ", depName='" + department.getdName() + '\'' +
                '}';
    }
}
