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
    final ObjectMapper mapper;

    List<Employee> employeeList = new ArrayList();

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = repository.findAll();
        employeeEntities.forEach(employeeEntity -> {
            employeeList.add(mapper.convertValue(employeeEntity,Employee.class));
        });
        return employeeList;
    }
}
