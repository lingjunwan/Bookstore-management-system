package com.example.demo.exception;

public class BookstoreException extends RuntimeException{

    private String message;

    public BookstoreException(String message){
        super(message);
        this.message = message;
    }

}