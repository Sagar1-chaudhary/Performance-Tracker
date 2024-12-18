package com.example.Performance_Tracker.Controller;

import com.example.Performance_Tracker.DTO.EmployeeResponse;
import com.example.Performance_Tracker.Entity.Employee;
import com.example.Performance_Tracker.Repository.EmployeeRepository;
import com.example.Performance_Tracker.Service.EmployeeService;
import com.example.Performance_Tracker.constants.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_EMPLOYEE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    @GetMapping(ApiConstant.GET_EMPLOYEES)
    public List<EmployeeResponse> getAllEmployees() {
        ResponseEntity<List<EmployeeResponse>> responseEntity = employeeService.getAllEmployees();

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to fetch employees");
        }
    }

    // Get employee by empCode
    @GetMapping(ApiConstant.GET_EMPLOYEE_BY_EMPLOYEE_CODE + ApiConstant.API_EMPLOYEE_BY_CODE)
    public ResponseEntity<EmployeeResponse> getEmployeeByEmpCode(@PathVariable Integer empCode) {
        ResponseEntity<EmployeeResponse> response = employeeService.getEmpByID(empCode);
        return response;
    }

    @PostMapping(ApiConstant.ADD_EMPLOYEE)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

//    @PutMapping(ApiConstant.UPDATE_EMPLOYEE + ApiConstant.API_EMPLOYEE_BY_CODE)
//    public ResponseEntity<String> updateEmployee(@PathVariable Integer empCode, @RequestBody Employee employee) {
//        employee.setEmpCode(empCode);
//        employeeService.createEmployee(employee);// Set the empCode value (ensure empCode is Integer)
//        return ResponseEntity.ok().build();
//    }
//
    // Delete an employee
    @DeleteMapping(value = ApiConstant.DELETE_EMPLOYEE + ApiConstant.API_EMPLOYEE_BY_CODE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer empCode) {
       return employeeService.deleteEmployee(empCode);
    }
}
