package com.example.walmart.service;

//import com.example.walmart.db.UserData;
import com.example.walmart.db.userJPAdb;
import com.example.walmart.exception.UserAlreadyExistWithThisID;
import com.example.walmart.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

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

            throw new UserAlreadyExistWithThisID("User Already Exist with this ID!");
        }

        userjpadb.save(user);
        return "User Added Successfully";
    }
    public User getUserByID(int id){

        return userjpadb.findById(id).orElse(null);
    }
    public List<User> displayUsers(){

        return userjpadb.findAll();
    }
}
