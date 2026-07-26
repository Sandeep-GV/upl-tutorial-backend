package com.upl.upl_tutorial_backend.controller;

import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    // POST API - Create User
    @PostMapping
    public User createUser(@RequestBody User user){

        return userService.saveUser(user);
    }


    // GET API - Get All Users
    @GetMapping
    public List<User> getUsers(){

        return userService.getAllUsers();
    }


    // GET API - Get User By ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){

        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user){

        return userService.updateUser(id, user);
    }




    // DELETE API
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return "User deleted successfully";



    }

}