package com.upl.upl_tutorial_backend.controller;


import com.upl.upl_tutorial_backend.dto.LoginRequest;
import com.upl.upl_tutorial_backend.dto.LoginResponse;
import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.repository.UserRepository;
import com.upl.upl_tutorial_backend.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtService jwtService;



    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ){


        // DEBUG 1: Check received data

        System.out.println("========== LOGIN DEBUG ==========");
        System.out.println("Email received: " + request.getEmail());
        System.out.println("Password received: " + request.getPassword());



        // Find user by email

        User user =
                userRepository.findByEmail(request.getEmail())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found for email: "
                                                + request.getEmail()
                                )
                        );



        // DEBUG 2: Check database user

        System.out.println("User found:");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Role: " + user.getRole());



        // Check password

        if(!user.getPassword()
                .equals(request.getPassword())){


            System.out.println("Password mismatch");


            throw new RuntimeException(
                    "Invalid password"
            );

        }



        System.out.println("Password matched");



        // Generate JWT token

        String token =
                jwtService.generateToken(
                        user.getEmail(),
                        user.getRole()
                );


        LoginResponse response =
                new LoginResponse();


        response.setToken(token);



        System.out.println("JWT generated successfully");


        return ResponseEntity.ok(response);

    }

}