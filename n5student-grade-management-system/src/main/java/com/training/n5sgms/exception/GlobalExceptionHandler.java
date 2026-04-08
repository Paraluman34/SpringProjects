package com.training.n5sgms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException; // Thrown when @Valid fails.
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap; 
import java.util.Map;

@RestControllerAdvice // makes this class a global listener for exceptions thrown by controllers.
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) //tells spring Whenever a MethodArgumentNotValidException happens, call this method
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    //for student id not found
     @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotFound(StudentNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND );
    }
    // NEW: handle invalid ID format (letters instead of numbers)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid student ID format. ID must be a number.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}


