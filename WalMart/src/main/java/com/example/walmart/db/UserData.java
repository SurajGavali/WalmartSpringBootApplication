package com.example.walmart.db;

import com.example.walmart.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserData {

    List<User> userList = new ArrayList<>();

    private void addDummyUser(){

        userList.add(User.builder()
                        .userID(1)
                        .userName("demo")
                        .userEmailID("demo@gmail.com")
                        .userPassword("Password@123")
                        .build()
                );
    }

    public Optional<User> getUserByID(int id) {
        return userList.stream().filter(user -> user.getUserID()==id).findFirst();
    }

    public void addNewUser(User user) {
        userList.add(user);
    }

    public List<User> returnUserList(){
//        addDummyUser();
        return userList;
    }
}
