package com.upl.upl_tutorial_backend.service;

import com.upl.upl_tutorial_backend.entity.User;
import com.upl.upl_tutorial_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Create User
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    // Get User By ID
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    // Update User
    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }


    // Delete User
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}