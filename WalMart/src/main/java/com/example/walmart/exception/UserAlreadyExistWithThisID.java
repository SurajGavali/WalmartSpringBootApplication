package com.example.walmart.exception;

public class UserAlreadyExistWithThisID extends RuntimeException{
    public UserAlreadyExistWithThisID(String message) {
        super(message);
    }
}
