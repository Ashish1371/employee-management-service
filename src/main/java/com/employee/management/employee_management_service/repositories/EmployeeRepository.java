package com.employee.management.employee_management_service.repositories;

import com.employee.management.employee_management_service.entities.EmployeeEntity;
import com.employee.management.employee_management_service.requests.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
  public EmployeeEntity findByUsername(String username);

}