package com.example.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class Advice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound() {
        return new ResponseEntity<>("there some issues!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
