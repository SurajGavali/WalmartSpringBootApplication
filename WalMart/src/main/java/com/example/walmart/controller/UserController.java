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
    @GetMapping("/users/sorted")
    public ResponseEntity<List<User>> getUserList(@RequestParam(required = false,defaultValue = "false") boolean requiredSortedList,
                                                  @RequestParam(required = false,defaultValue = "1")int pageNo,
                                                  @RequestParam(required = false,defaultValue = "2") int pageSize){

        return ResponseEntity.ok(userService.getUserList(requiredSortedList, pageNo, pageSize));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> displayUserByID(@PathVariable(name = "id") int ID){

        return ResponseEntity.ok(userService.getUserByID(ID));
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> adduser(@Validated @RequestBody User user){

        return ResponseEntity.ok(userService.RegisterNewUser(user));
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deluser(@PathVariable(name = "id") int userID){
        return ResponseEntity.ok(userService.DeleteUser(userID));
    }
    @DeleteMapping("/deletedall")
    public ResponseEntity<String> delallusers(){
        return ResponseEntity.ok(userService.DeleteAllUser());
    }
}
