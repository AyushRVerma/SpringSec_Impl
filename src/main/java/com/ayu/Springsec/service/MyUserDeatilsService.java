package com.ayu.Springsec.service;

import com.ayu.Springsec.model.UserModel;
import com.ayu.Springsec.model.userprinciple;
import com.ayu.Springsec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class MyUserDeatilsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("ENTERED USERNAME: " + username);

        UserModel user = repo.findByUsername(username);

        System.out.println("USER FROM DB: " + user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new userprinciple(user);
    }
}