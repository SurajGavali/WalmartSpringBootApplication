package com.example.walmart.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Data
@Entity
@Table(name = "users")
//@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity{

    @Id
    @SequenceGenerator(name = "user_seq" ,sequenceName = "user_seq", initialValue = 101,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private int userID;

    @Column(name = "user_name",length = 100,nullable = false,unique = true)
    private String userName;
    @NotBlank(message = "Email Can't Be Empty!")
    private String userEmailID;
    @NotBlank(message = "Password Can't Be Empty!")
    private String userPassword;
    public User() {}
}
