package com.upl.upl_tutorial_backend.service;


import com.upl.upl_tutorial_backend.dto.AdminUserDTO;
import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.repository.UserRepository;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class AdminUserService {



    private final UserRepository userRepository;



    public AdminUserService(
            UserRepository userRepository
    ){

        this.userRepository = userRepository;

    }






    // ==========================
    // GET ALL USERS
    // ==========================

    public List<AdminUserDTO> getAllUsers(){


        return userRepository.findAll()

                .stream()

                .map(user -> new AdminUserDTO(

                        user.getId(),

                        user.getName(),

                        user.getEmail(),

                        user.getRole(),

                        user.getStatus()

                ))

                .collect(Collectors.toList());

    }








    // ==========================
    // GET USER BY ID
    // ==========================

    public AdminUserDTO getUserById(
            Long id
    ){


        User user =
                userRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "User not found"
                                )

                        );



        return new AdminUserDTO(

                user.getId(),

                user.getName(),

                user.getEmail(),

                user.getRole(),

                user.getStatus()

        );

    }








    // ==========================
    // UPDATE USER STATUS
    // ==========================

    public AdminUserDTO updateStatus(

            Long id,

            String status

    ){



        User user =
                userRepository.findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "User not found"
                                )

                        );



        user.setStatus(status);



        User updatedUser =
                userRepository.save(user);




        return new AdminUserDTO(

                updatedUser.getId(),

                updatedUser.getName(),

                updatedUser.getEmail(),

                updatedUser.getRole(),

                updatedUser.getStatus()

        );


    }


}