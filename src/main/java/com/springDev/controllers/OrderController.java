package com.springDev.controllers;

import com.springDev.customexceptions.UserNotFoundException;
import com.springDev.entities.Order;
import com.springDev.entities.User;
import com.springDev.repositaries.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepositary userRepositary;

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
        Optional<User> user=userRepositary.findById(userid);
        if(!user.isPresent()){
            throw  new UserNotFoundException("User not found in user repository");
        }
        return user.get().getOrders();

    }
}
