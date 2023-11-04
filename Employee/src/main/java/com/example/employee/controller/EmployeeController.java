package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeService.findAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
