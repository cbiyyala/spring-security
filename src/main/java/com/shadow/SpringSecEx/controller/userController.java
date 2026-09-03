package com.shadow.SpringSecEx.controller;

import com.shadow.SpringSecEx.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.SpringSecEx.model.users;

@RestController
public class userController {

    @Autowired
    private userService userService;
    
    @PostMapping("/register")
    public users register(@RequestBody users user) {
        // Logic to register the user
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody users user) {
        return userService.loginUser(user);
        // return "Successfully logged in as " + user.getUsername();
    }

}
