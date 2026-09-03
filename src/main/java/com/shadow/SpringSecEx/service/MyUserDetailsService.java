package com.shadow.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shadow.SpringSecEx.model.UserPrincipal;
import com.shadow.SpringSecEx.model.users;
import com.shadow.SpringSecEx.repo.userRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private userRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user); 
    }

}
