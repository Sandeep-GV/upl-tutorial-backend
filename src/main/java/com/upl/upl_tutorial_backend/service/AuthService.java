package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.repository.UserRepository;
import com.upl.upl_tutorial_backend.security.JwtService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {


    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final BCryptPasswordEncoder passwordEncoder;



    public AuthService(
            UserRepository userRepository,
            JwtService jwtService,
            BCryptPasswordEncoder passwordEncoder
    ){

        this.userRepository = userRepository;

        this.jwtService = jwtService;

        this.passwordEncoder = passwordEncoder;

    }



    public String login(
            String email,
            String password
    ){


        User user = userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        )
                );



        if(!passwordEncoder.matches(
                password,
                user.getPassword()
        )){

            throw new RuntimeException(
                    "Invalid password"
            );

        }



        // Generate JWT with Role

        String token =
                jwtService.generateToken(
                        user.getEmail(),
                        user.getRole()
                );



        return token;

    }


}