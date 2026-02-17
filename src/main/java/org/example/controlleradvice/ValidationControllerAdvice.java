package org.example.controlleradvice;

import org.example.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** custom exception error handler */
@RestControllerAdvice
public class ValidationControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleException(ValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}