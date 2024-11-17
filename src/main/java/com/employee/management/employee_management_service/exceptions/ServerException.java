package com.employee.management.employee_management_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ServerException() {
        super(String.format("Something went wrong"));

    }
}
