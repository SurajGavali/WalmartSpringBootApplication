package com.example.walmart.exception;

public class OutOfSizePageSize extends RuntimeException{

    public OutOfSizePageSize(String msg){

        super(msg);
    }
}
