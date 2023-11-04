package com.example.employee.repository;

import com.example.employee.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
@Query (value = "select  * from  employee_type", nativeQuery = true)
    List<EmployeeType> findAllEmployeeType();
}
