package com.example.hrportal.service;

import com.example.hrportal.model.Employee;
import com.example.hrportal.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setDepartment(updatedEmployee.getDepartment());
            emp.setEmail(updatedEmployee.getEmail());
            emp.setSalary(updatedEmployee.getSalary());
            return repository.save(emp);
        }).orElse(null);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}