package com.example.walmart.exception.handler;

import com.example.walmart.exception.UserAlreadyExistWithThisID;
import com.example.walmart.exception.UserDoesNotExist;
import com.example.walmart.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    public ErrorMessage errorMessage(String errmsg, int scode){
        return ErrorMessage.builder().message(errmsg).statusCode(scode).build();
    }
    @ExceptionHandler({UserAlreadyExistWithThisID.class})
    public ErrorMessage handleUserAlreadyExistException(Exception e){
        return errorMessage(e.getMessage(), HttpStatus.CONFLICT.value());
    }
    @ExceptionHandler({UserDoesNotExist.class})
    public ErrorMessage handleUserDoesNotExist(Exception e){
        return errorMessage(e.getMessage(),HttpStatus.NOT_FOUND.value());
    }
}
