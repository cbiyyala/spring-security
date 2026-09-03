package com.shadow.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shadow.SpringSecEx.model.users;
import com.shadow.SpringSecEx.repo.userRepo;

@Service
public class userService {

    @Autowired
    private userRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public users registerUser(users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users registeredUser = repo.save(user);

        return registeredUser;
    }

    public String loginUser(users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());

            // return "Successfully logged in as " + user.getUsername();

        } else {
            return "Invalid username or password";
        }
    }
        

}
