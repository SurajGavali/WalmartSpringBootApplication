package com.example.walmart.service;

import com.example.walmart.db.userJPAdb;
import com.example.walmart.exception.UserAlreadyExistWithThisID;
import com.example.walmart.exception.UserDoesNotExist;
import com.example.walmart.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
@Component
public class UserService {
    @Autowired
    private userJPAdb userjpadb;

    public String RegisterNewUser(User user){

        log.info("Registering New User");
        User existingUser = userjpadb.findUserByuserName(user.getUserName());

        log.info("existingUser :: " + existingUser);
        if(Objects.nonNull(existingUser)){

            throw new UserAlreadyExistWithThisID("User Already Exist with this UserName!");
        }

        userjpadb.save(user);
        return "User Added Successfully";
    }

    public String DeleteUser(int id) {

        log.info("Deleting the user form database");

        log.info("ID :: " + id);
        try {
            if (Objects.nonNull(userjpadb.findById(id))) {
                userjpadb.deleteById(id);
                return "Deleted user with id " + id;
            }
        }
        catch(Exception e) {
            throw new UserDoesNotExist("Arrrrrrrrrrrrr data nay ki re delete karay");
        }
        return "Euuuuuuuuuu Delete User";
    }
    public String DeleteAllUser() {

        log.info("Deleting the user form database");
        userjpadb.deleteAll();

        return "All Users deleted successfully";
    }
    public User getUserByID(int id){
        try {
            if (Objects.nonNull(userjpadb.findById(id))) {

                return userjpadb.findById(id).orElseThrow();
            }
        }
        catch (Exception e) {

            throw new UserDoesNotExist("Arrrrr User nay ki re show karay");
        }
        return null;
    }
    public List<User> displayUsers(){

        return userjpadb.findAll();
    }
}
