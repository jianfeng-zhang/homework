package com.example.homework.exception;

import java.util.concurrent.TimeoutException;

public class MyException extends RuntimeException {
    public MyException(){};
    public MyException(String input){
        super(input);
    }
}
