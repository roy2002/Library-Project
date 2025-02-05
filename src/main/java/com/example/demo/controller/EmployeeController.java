package com.example.demo.controller;


import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("v1/api")
public class EmployeeController{

    @Autowired
    com.example.demo.service.EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int empId){

        Optional<Employee> employee = employeeService.getEmployeeById(empId);
        if (employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else
            return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){

        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        }
        catch(RuntimeException ex){
            return new ResponseEntity<>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){

        try {

            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
        }

        catch(RuntimeException ex){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


    @GetMapping("employee/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

//    @PostMapping("employee/all/employee")
//        public List<Employee> getAll(){
//
//        return '';
//
//    }


}
