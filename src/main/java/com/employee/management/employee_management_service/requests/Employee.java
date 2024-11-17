package com.employee.management.employee_management_service.requests;

import lombok.Data;

@Data
public class Employee {
    String firstName,lastName,dateOfBirth,dateOfJoining,role,gender,userName,password,email;
    int age;
}
