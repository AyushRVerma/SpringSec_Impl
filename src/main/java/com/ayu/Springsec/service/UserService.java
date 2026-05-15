package com.ayu.Springsec.service;

import com.ayu.Springsec.controller.Users;
import com.ayu.Springsec.model.UserModel;
import com.ayu.Springsec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo repo;
    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserModel register(UserModel user) {
        user.setPassword(encoder.encode(user.getPassword()));
//        System.out.println(encoder.encode("ayu"));
        return repo.save(user);


    }

    public String verify(UserModel user) {
        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken
                                (user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());


        return "failure";


    }
}
