package com.employee.management.employee_management_service.utils;

import com.employee.management.employee_management_service.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class Patcher {
    public static EmployeeEntity employeePatcher(EmployeeEntity existing, EmployeeEntity incomplete) throws IllegalAccessException {

        Class<?> Class= EmployeeEntity.class;
        Field[] employeeFields=Class.getDeclaredFields();
        System.out.println(employeeFields.length);
        for(Field field : employeeFields){
            System.out.println(field.getName());
            field.setAccessible(true);
            Object value=field.get(incomplete);
            if(value!=null){
                if(!value.equals(0L))
                {
                    field.set(existing,value);
                }
            }

            field.setAccessible(false);
        }
        return existing;
    }

}
