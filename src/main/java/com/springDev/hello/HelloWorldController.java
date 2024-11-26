package com.springDev.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/helloWorld-bean")
    public UserDetails helloWorldBean (){
        return new UserDetails("Mohit","Singh","Jaipur");
    }
}
