package com.employee.management.employee_management_service.services;

import com.employee.management.employee_management_service.entities.EmployeeEntity;
import com.employee.management.employee_management_service.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employee)
    {
        return employeeRepository.save(employee);
    }
    public void removeEmployee()
    {

    }

    public Optional<EmployeeEntity> findEmployee(long employeeId)
    {
        return employeeRepository.findById(employeeId);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee)
    {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(long employeeId)
    {
        employeeRepository.deleteById(employeeId);
    }
    public Page<EmployeeEntity> getAllEmployee(int pageNo, int pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<EmployeeEntity> pagedResult = employeeRepository.findAll(paging);
        return  pagedResult;
    }

    public EmployeeEntity findByUsername(String username)
    {
        return employeeRepository.findByUsername(username);
    }
}
