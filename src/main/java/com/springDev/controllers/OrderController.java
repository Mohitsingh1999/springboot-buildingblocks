package com.springDev.controllers;

import com.springDev.customexceptions.UserNotFoundException;
import com.springDev.entities.Order;
import com.springDev.entities.User;
import com.springDev.repositaries.OrderRepositary;
import com.springDev.repositaries.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepositary userRepositary;
    @Autowired
    private OrderRepositary orderRepositary;

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
        Optional<User> user=userRepositary.findById(userid);
        if(!user.isPresent()){
            throw  new UserNotFoundException("User not found in user repository");
        }
        return user.get().getOrders();
    }
    @PostMapping("/{userid}/orders")
    public Order createOrder(@PathVariable Long userid,@RequestBody Order order) throws UserNotFoundException{
        Optional<User> userOptional=userRepositary.findById(userid);
        if(!userOptional.isPresent()){
            throw  new UserNotFoundException("User not found in user repository");
        }
        User user=userOptional.get();
        order.setUser(user);
        return orderRepositary.save(order);
    }
}
