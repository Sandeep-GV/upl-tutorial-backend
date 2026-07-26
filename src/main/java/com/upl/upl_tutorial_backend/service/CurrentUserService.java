package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class CurrentUserService {



    private final UserRepository userRepository;



    public CurrentUserService(
            UserRepository userRepository
    ){

        this.userRepository = userRepository;

    }




    public Long getCurrentUserId(){



        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();



        if(authentication == null){

            throw new RuntimeException(
                    "User not authenticated"
            );

        }



        String email =
                authentication.getName();



        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );



        return user.getId();

    }


}