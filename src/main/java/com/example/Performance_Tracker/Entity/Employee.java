package com.example.Performance_Tracker.Entity;

import com.example.Performance_Tracker.constants.ApiConstant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ApiConstant.EMPLOYEE_CODE)
    private Integer empCode;  // Primary key field

    @NotNull
    @Column(name = "emp_name")
    private String empName;

    @NotNull
    @Column(name = "job_role")
    private String jobRole;

    @NotNull
    @Column(name = "salary")
    private String salary;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "phone")
    private String phone;

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
