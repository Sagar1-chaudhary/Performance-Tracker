package com.example.Performance_Tracker.constants;

import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

public class ApiConstant {

    private ApiConstant(){

    }
    public static final String EMPLOYEE_CODE = "emp_code";
    public static final String API_EMPLOYEE = "/api/employees";
    public static final String API_EMPLOYEE_BY_CODE = "/{empCode}";
    public static final String GET_EMPLOYEES = "/getEmployees";
    public static final String ADD_EMPLOYEE = "/addEmployee";
    public static final String UPDATE_EMPLOYEE = "/updateEmployee";
    public static final String DELETE_EMPLOYEE = "/deleteEmployee";
    public static final String GET_EMPLOYEE_BY_EMPLOYEE_CODE = "/getEmployeeByEmpCode";
}