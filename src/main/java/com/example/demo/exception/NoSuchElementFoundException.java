package com.example.demo.exception;

public class NoSuchElementFoundException extends RuntimeException{

    private String message;

    public NoSuchElementFoundException(String message) {
        super(message);
        this.message = message;
    }

}