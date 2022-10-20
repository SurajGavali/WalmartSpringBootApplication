package com.example.walmart.db;

import com.example.walmart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Integer is primary key
@Repository
public interface userJPAdb extends JpaRepository<User,Integer> {

    User findUserByuserName(String userName);
}
