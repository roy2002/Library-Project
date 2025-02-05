package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(int employeeId){
        if(employeeRepository.findById(employeeId).isPresent()) {
            employeeRepository.deleteById(employeeId);
        }
        else{
            throw new RuntimeException("Employee not found");
        }
    }
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            emp.setName(updatedEmployee.getName());
            emp.setEmail(updatedEmployee.getEmail());
            return employeeRepository.save(emp);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}
