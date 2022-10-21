package com.example.walmart.exception;

public class UserDoesNotExist extends RuntimeException{
    public UserDoesNotExist(String msg){
        super(msg);
    }
}
