package com.example.Performance_Tracker.Service;

import com.example.Performance_Tracker.DTO.EmployeeResponse;
import com.example.Performance_Tracker.Entity.Employee;
import com.example.Performance_Tracker.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            List<EmployeeResponse> employeeResponses = employees.stream()
                    .map(employee -> new EmployeeResponse(
                            employee.getEmpCode(),
                            employee.getEmpName(),
                            employee.getJobRole(),
                            employee.getSalary(),
                            employee.getEmail(),
                            employee.getPhone()
                    ))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(employeeResponses, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<EmployeeResponse> getEmpByID(Integer empCode) {
        Optional<Employee> employeeResponse = employeeRepository.findById(empCode);
        EmployeeResponse response = new EmployeeResponse(
                employeeResponse.get().getEmpCode(),
                employeeResponse.get().getEmpName(),
                employeeResponse.get().getJobRole(),
                employeeResponse.get().getSalary(),
                employeeResponse.get().getEmail(),
                employeeResponse.get().getPhone());
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity<Object> createEmployee(Employee employee) {
        try {
            // Check if the email already exists
            Optional<Employee> existingEmail = employeeRepository.findByEmail(employee.getEmail());
            Optional<Employee>  existingEmpCode = null;
            if(employee.getEmpCode() != null) {
                existingEmpCode = employeeRepository.findById(employee.getEmpCode());
            }
            if (existingEmail.isPresent()) {
                return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
            } else if (existingEmpCode.isPresent()) {
                return new ResponseEntity<>("Employee already exists", HttpStatus.BAD_REQUEST);
            }

            // Save the employee if no conflicts
            Employee savedEmployee = employeeRepository.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Handle the optimistic locking exception (e.g., retry logic or error message)
            return new ResponseEntity<>("Optimistic locking failure. Please try again.", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteEmployee(Integer empCode) {
        Optional<Employee> existingEmpCode = employeeRepository.findById(empCode);
        if (existingEmpCode.isPresent()) {
            employeeRepository.deleteById(empCode);
            return new ResponseEntity<>(empCode + " employee deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee does not exists!", HttpStatus.BAD_REQUEST);
    }
}
