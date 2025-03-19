package com.dev.controller;

import java.util.List;
import java.util.Optional;

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
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

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
    
    @DeleteMapping("/{id}")
    public boolean deleteUser(@RequestParam Long id) {
        return userService.DeleteUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    
}