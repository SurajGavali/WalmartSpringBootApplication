package com.example.walmart.controller;

import com.example.walmart.model.User;
import com.example.walmart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/walmart")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> displayUsers(){

        return ResponseEntity.ok(userService.displayUsers());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> displayUserByID(@PathVariable(name = "id") int userID){

        return ResponseEntity.ok(userService.getUserByID(userID));
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> adduser(@Validated @RequestBody User user){
        return ResponseEntity.ok(userService.RegisterNewUser(user));
    }


}
