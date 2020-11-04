package com.thoughtworks.capacity.gtb.mvc.component;

import com.thoughtworks.capacity.gtb.mvc.error.Error;
import com.thoughtworks.capacity.gtb.mvc.error.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handle(ConstraintViolationException e) {
        String message = "";
        for (ConstraintViolation<?> constraint : e.getConstraintViolations()) {
            message = constraint.getMessage();
            break;
        }
        Error error = new Error(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handle(MethodArgumentNotValidException e) {
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        Error error = new Error(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Error> handle(UserExistException e) {
        String message = e.getMessage();
        Error error = new Error(HttpStatus.BAD_REQUEST.value(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
