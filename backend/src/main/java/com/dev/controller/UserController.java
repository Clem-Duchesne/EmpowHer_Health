package com.dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dev.model.UserModels.User;
import com.dev.services.UserService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@RequestParam Long id) {
        Optional<User> user = userService.getUserById(id);
        if(user != null){
            return user.get();
        }
        else{
            return null;
        }
                
    }
    
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@RequestParam Long id) {
        return userService.DeleteUser(id);
    }

    @PostMapping()
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            // Initialize userRoles and set the default role
            if (user.getUserRoles() == null || user.getUserRoles().isEmpty()) {
                List<String> userRoles = new ArrayList<>();
                userRoles.add("patient");
                user.setUserRoles(userRoles);
            }

            // Create the user and return the result
            User createdUser = userService.createUser(user);

            // Return successful response
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            // Return an error response in case of failure
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    
}