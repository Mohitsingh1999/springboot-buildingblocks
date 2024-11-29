package com.springDev.service;

import com.springDev.entities.User;
import com.springDev.repositaries.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepositary userRepositary;

    public List<User> getAllUsers(){
        return userRepositary.findAll();

    }

    public User createUser(User user){
        return userRepositary.save(user);
    }

    public Optional<User> getUserById(Long id){
        Optional<User> user=userRepositary.findById(id);
        return user;
    }

    public User updateUserById(Long id, User user){
        user.setId(id);
        return userRepositary.save(user);
    }

}
