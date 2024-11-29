package com.springDev.service;

import com.springDev.entities.User;
import com.springDev.repositaries.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepositary userRepositary;

    public List<User> getAllUsers(){
        return userRepositary.findAll();

    }

}
