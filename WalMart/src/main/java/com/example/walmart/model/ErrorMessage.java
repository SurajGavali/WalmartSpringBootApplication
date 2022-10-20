package com.example.walmart.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorMessage {

    private int statusCode;
    private String message;
}
