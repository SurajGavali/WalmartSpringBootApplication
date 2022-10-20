package com.example.walmart.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int userID;

    @Column(name = "user_name",length = 100,nullable = false,unique = true)
    private String userName;
    @NotBlank(message = "Email Can't Be Empty!")
    private String userEmailID;
    @NotBlank(message = "Password Can't Be Empty!")
    private String userPassword;

    public User() {}
}
