package org.emp.employeeController;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor //constructor injection
public class EmployeeController {

    final EmployeeService employeeServiceImpl; //constructor injection

    @PostMapping("add-employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeServiceImpl.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

}
