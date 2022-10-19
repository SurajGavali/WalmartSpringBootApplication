package com.example.walmart.controller;

import com.example.walmart.model.User;
import com.example.walmart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/walmart")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    User user;

    @GetMapping("/users")
    public ResponseEntity<List<User>> displayUsers(){

        return ResponseEntity.ok(userService.displayUsers());
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> adduser(@RequestBody User user){
        return ResponseEntity.ok(userService.RegisterNewUser(user));
    }
}
