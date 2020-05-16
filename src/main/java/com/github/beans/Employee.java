package com.github.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class Employee {
    private Integer empId;

    private String emoName;

    private String empGender;

    private String empEmail;

    private Integer deptId;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public Employee setDept(Dept dept) {
        this.dept = dept;
        return this;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmoName() {
        return emoName;
    }

    public void setEmoName(String emoName) {
        this.emoName = emoName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}