package com.employee.management.employee_management_service.controllers;
import com.employee.management.employee_management_service.entities.EmployeeEntity;
import com.employee.management.employee_management_service.exceptions.ResourceNotFoundException;
import com.employee.management.employee_management_service.exceptions.ServerException;
import com.employee.management.employee_management_service.services.EmployeeService;
import com.employee.management.employee_management_service.utils.Patcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck(){
        return  new ResponseEntity<String>("Health check successful",HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeEntity> createNewEmployee(@RequestBody EmployeeEntity employee)
    {
        try {
            employeeService.createNewEmployee(employee);
            return  new ResponseEntity<EmployeeEntity>(employee,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            throw new ServerException();
        }
    }

    @PutMapping("/employee/{id}")
    public EmployeeEntity updateOrCreateEmployee(@PathVariable long id, @RequestBody EmployeeEntity employee)
    {
        Optional<EmployeeEntity> existingEmployee=Optional.of (employeeService.findEmployee(id)
                .orElseThrow (() -> new ResourceNotFoundException ("Employee","id",id)));
        try {
            EmployeeEntity employeeData=Patcher.employeePatcher(existingEmployee.get(),employee);
            employeeService.updateEmployee(employeeData);

        }catch (Exception e){
            throw new ServerException();
        }
        return existingEmployee.get();
    }

    @PatchMapping("/employee/{id}")
    public EmployeeEntity patchEmployee(@PathVariable long id, @RequestBody EmployeeEntity employee)
    {
        Optional<EmployeeEntity> existingEmployee=Optional.of (employeeService.findEmployee(id)
                .orElseThrow (() -> new ResourceNotFoundException ("Employee","id",id)));
        try {
            EmployeeEntity employeeData=Patcher.employeePatcher(existingEmployee.get(),employee);
            employeeService.updateEmployee(employeeData);

        }catch (Exception e){
            throw new ServerException();
        }
        return existingEmployee.get();
    }
    @GetMapping("/employee/{id}")
    public Optional<EmployeeEntity> getEmployee(@PathVariable long id)
    {
        return Optional.of (employeeService.findEmployee(id)
                .orElseThrow (() -> new ResourceNotFoundException ("Employee","id",id)));
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id)
    {
         Optional.of (employeeService.findEmployee(id)
                .orElseThrow (() -> new ResourceNotFoundException ("Employee","id",id)));
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees")
    public Page<EmployeeEntity> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize){
        return employeeService.getAllEmployee(pageNo,pageSize);
    }

    @GetMapping("/employee")
    public EmployeeEntity findByUsername(@RequestParam  String username){
        return employeeService.findByUsername(username);
    }
}
