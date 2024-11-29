package com.springDev.controllers;

import com.springDev.entities.User;
import com.springDev.service.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id,@RequestBody User user){
        return userService.updateUserById(id,user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

//    @GetMapping("/users/byusername/{userName}")
//    public User getUserByUsername(@PathVariable("userName") String userName){
//        return userService.getUserByUsername(userName);
//
//    }


}
