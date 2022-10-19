package com.example.walmart.service;

import com.example.walmart.db.UserData;
import com.example.walmart.exception.UserAlreadyExistWithThisID;
import com.example.walmart.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    UserData userData = new UserData();


    public List<User> displayUsers(){
        log.info("*****Displaying User List*****");
        return userData.returnUserList();
    }

    public String RegisterNewUser(User user){

        log.info("Registering New User");
        Optional<User> existingUser = userData.getUserByID(user.getUserID());

        log.info("Existing user " + existingUser.isPresent());
        if(existingUser.isPresent()){
            new UserAlreadyExistWithThisID("User Already Exist With This ID!");
        }
        else{

            userData.addNewUser(User.builder()
                            .userID(user.getUserID())
                            .userName(user.getUserName())
                            .userEmailID(user.getUserEmailID())
                            .userPassword(user.getUserPassword()).build()
                    );
        }

        return userData.returnUserList().toString();

    }
}
