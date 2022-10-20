//package com.example.walmart.model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//@Table(name = "resevation")
//public class Reservation extends BaseEntity{
//    @Id
//    @SequenceGenerator(name = "res_user_id" ,sequenceName = "res_user_id", initialValue = 101,allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "res_user_id")
//    private int reservationID;
//
//    @Column
//    private LocalDate startDate;
//
//    @Column
//    private LocalDate endDate;
//
//    @Column
//    @JsonFormat(pattern = "HH:mm")
//    private LocalTime startTime;
//
//    @Column
//    @JsonFormat(pattern = "HH:mm")
//    private LocalTime endTime;
//
//    @PrePersist
//    public void prePersist(){
//        lastCreatedAt = LocalDateTime.now();
//        lastModifiedAt = LocalDateTime.now();
//
//    }
//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
//    User user;
//
//    @PreUpdate
//    public void preUpdate(){
//        lastModifiedAt = LocalDateTime.now();
//    }
//}
