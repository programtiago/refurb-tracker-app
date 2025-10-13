package com.devtiago.refurbtracker.refurb_rh.exceptions;

import com.devtiago.refurbtracker.refurb_core.exceptions.EmployeeException;
import com.devtiago.refurbtracker.refurb_core.exceptions.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeException(EmployeeException ex, HttpServletRequest req){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        com.devtiago.refurbtracker.refurb_core.exceptions.ErrorResponse error = new com.devtiago.refurbtracker.refurb_core.exceptions.ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(status).body(error);
    }
}
