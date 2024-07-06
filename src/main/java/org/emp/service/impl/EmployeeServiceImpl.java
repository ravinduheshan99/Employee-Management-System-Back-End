package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //constructor injection
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository; //constructor injection

    List<Employee> employeeList = new ArrayList();

    @Override
    public Employee addEmployee(Employee employee) {
        EmployeeEntity entity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repository.save(entity);
        return new ObjectMapper().convertValue(entity,Employee.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = repository.findAll();
        employeeEntities.forEach(employeeEntity -> {
            employeeList.add(new ObjectMapper().convertValue(employeeEntity,Employee.class));
        });
        return employeeList;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (repository.findById(employee.getId()).isPresent()){
            EmployeeEntity entity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
            repository.save(entity);
            return new ObjectMapper().convertValue(entity,Employee.class);
        }
        return null;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        if (repository.findById(id).isPresent()){
            return new ObjectMapper().convertValue(repository.findById(id),Employee.class);
        }
        return null;
    }

    @Override
    public List<Employee> findAllEmployeesByFirstName(String fname) {
        Iterable<EmployeeEntity> employeeEntities = repository.findAllByFirstName(fname);
        List<Employee> employees = new ArrayList<>();
        employeeEntities.forEach(employeeEntity -> {
            employees.add(new ObjectMapper().convertValue(employeeEntity, Employee.class));
        });
        return employees;
    }
}
