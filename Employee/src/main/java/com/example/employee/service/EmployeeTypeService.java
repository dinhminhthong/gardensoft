package com.example.employee.service;

import com.example.employee.model.EmployeeType;
import com.example.employee.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService implements IEmployeeTypeService {
@Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> findAllType() {
        return employeeTypeRepository.findAll();
    }
}
