package com.example.walmart.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
//    private static int count;

    private int userID;
    private String userName;
    private String userEmailID;
    private String userPassword;
}
