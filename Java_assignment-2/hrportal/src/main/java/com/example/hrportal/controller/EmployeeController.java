package com.example.hrportal.controller;

import com.example.hrportal.model.Employee;
import com.example.hrportal.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
    private final EmployeeService service;
    private final HRController hrController;

    public EmployeeController(EmployeeService service, HRController hrController) {
        this.service = service;
        this.hrController = hrController;
    }

    private boolean isAuthorized(Map<String, String> headers) {
        System.out.println("Received Headers: " + headers);

        String token = headers.getOrDefault("Authorization", headers.getOrDefault("authorization", null));

        if (token == null) {
            throw new RuntimeException("Missing Authorization Header");
        }

        System.out.println("Processed Token: " + token);
        return hrController.isAuthenticated(token);
    }



    @GetMapping
    public List<Employee> getAllEmployees(@RequestHeader Map<String, String> headers) {
        if (!isAuthorized(headers)) {
            throw new RuntimeException("Unauthorized Access");
        }
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestHeader Map<String, String> headers, @RequestBody Employee employee) {
        if (!isAuthorized(headers)) {
            throw new RuntimeException("Unauthorized Access");
        }


        if (employee.getName() == null || employee.getName().trim().isEmpty() ||
                employee.getDepartment() == null || employee.getDepartment().trim().isEmpty() ||
                employee.getEmail() == null || employee.getEmail().trim().isEmpty() ||
                employee.getSalary() <= 0) {
            throw new RuntimeException("All fields (Name, Department, Email, Salary) are required and must be valid.");
        }

        return service.addEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestHeader Map<String, String> headers, @PathVariable Long id, @RequestBody Employee updatedEmployee) {
        if (!isAuthorized(headers)) {
            throw new RuntimeException("Unauthorized Access");
        }
        return service.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@RequestHeader Map<String, String> headers, @PathVariable Long id) {
        if (!isAuthorized(headers)) {
            throw new RuntimeException("Unauthorized Access");
        }
        service.deleteEmployee(id);
    }

}

