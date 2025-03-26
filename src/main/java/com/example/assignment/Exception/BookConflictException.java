package com.example.assignment.Exception;

public class BookConflictException extends RuntimeException{
    public BookConflictException(String msg){
        super(msg);
    }
}
