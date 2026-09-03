package com.shadow.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shadow.SpringSecEx.model.users;
import com.shadow.SpringSecEx.repo.userRepo;

@Service
public class userService {

    @Autowired
    private userRepo repo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public users registerUser(users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users registeredUser = repo.save(user);

        return registeredUser;
    }
        

}
