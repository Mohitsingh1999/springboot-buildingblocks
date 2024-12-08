package com.springDev.controllers;

import com.springDev.customexceptions.UserNameNotFoundException;
import com.springDev.entities.User;
import com.springDev.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id){
        try{
            return userService.getUserById(id);
        }catch (UserNameNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Long id,@RequestBody User user){
        try{
            return userService.updateUserById(id,user);
        }catch(UserNameNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/byusername/{userName}")
    public User getUserByUsername(@PathVariable("userName") String userName) throws UserNameNotFoundException{
        User user= userService.getUserByUsername(userName);
        if(user==null){
            throw new UserNameNotFoundException("Username "+userName+" not found in user repositary");
        }
        return  user;
    }
}
