package com.employee.management.employee_management_service.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Table(name = "Employee")
@Entity
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="age")
    long age;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="gender")
    private String gender;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="dateofbirth")
    private String dateOfBirth;
    @Column(name="dateofjoining")
    private String dateOfJoining;
}
