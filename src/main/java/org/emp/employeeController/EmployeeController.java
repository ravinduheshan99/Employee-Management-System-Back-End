package org.emp.employeeController;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor //constructor injection
public class EmployeeController {

    final EmployeeService employeeServiceImpl; //constructor injection

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @DeleteMapping("delete-emp/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public String deleteEmployee(@PathVariable Long id){
        boolean response = employeeServiceImpl.deleteEmployeeById(id);
        if (response){
            return "Successfully Deleted";
        }
        return "Operation Unsuccessful";
    }

    @PutMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee employeee){
        return employeeServiceImpl.updateEmployee(employeee);
    }
}
