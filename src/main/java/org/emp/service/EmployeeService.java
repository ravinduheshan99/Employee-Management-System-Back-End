package org.emp.service;

import org.emp.dto.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public boolean deleteEmployeeById(Long id);
    public Employee updateEmployee(Employee employee);
}
