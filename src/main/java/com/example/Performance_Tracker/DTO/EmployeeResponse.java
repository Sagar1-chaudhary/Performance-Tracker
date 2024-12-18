package com.example.Performance_Tracker.DTO;

public class EmployeeResponse{

    private Integer empCode;
    private String empName;
    private String jobRole;
    private String salary;
    private String email;
    private String phone;

    public EmployeeResponse(Integer empCode, String empName, String jobRole, String salary, String email, String phone) {
        this.empCode = empCode;
        this.empName = empName;
        this.jobRole = jobRole;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
    }

    public Integer getEmpCode() {
        return empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmpCode(Integer empCode) {
        this.empCode = empCode;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
