package com.example.demo.api;


import com.example.demo.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1/api")
public interface EmployeeInterface {

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee);

}
