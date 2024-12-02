package com.springDev.service;

import com.springDev.customexceptions.UserNotFoundException;
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

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user=userRepositary.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found in user Repositary");

        }
        return user;
    }

    public User updateUserById(Long id, User user){
        user.setId(id);
        return userRepositary.save(user);
    }

    public void deleteUserById(Long id){
        if(userRepositary.findById(id).isPresent()){
            userRepositary.deleteById(id);
        }


    }

//    public User getUserByUsername(String userName){
//        return userRepositary.findByUsername(userName);
//    }

}
