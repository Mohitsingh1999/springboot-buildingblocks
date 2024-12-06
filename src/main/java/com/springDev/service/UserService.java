package com.springDev.service;

import com.springDev.customexceptions.UserNameNotFoundException;
import com.springDev.entities.User;
import com.springDev.repositaries.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Optional<User> getUserById(Long id) throws UserNameNotFoundException {
        Optional<User> user=userRepositary.findById(id);
        if(!user.isPresent()){
            throw new UserNameNotFoundException("User not found in user Repositary");

        }
        return user;
    }

    public User updateUserById(Long id, User user) throws UserNameNotFoundException {
        Optional<User> optionalUser=userRepositary.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNameNotFoundException("User not found in user Repositary, Please provide the correct user id");
        }
        user.setId(id);
        return userRepositary.save(user);
    }

    public void deleteUserById(Long id){
        Optional<User> user=userRepositary.findById(id);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in user Repositary, Please provide the correct user id");
        }
        userRepositary.deleteById(id);

    }

    public User getUserByUsername(String userName){
        return userRepositary.findByUserName(userName);
    }

}
