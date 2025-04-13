package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.UserModels.User;
import com.dev.modelassembler.UserModelAssembler;
import com.dev.services.UserService;

@RestController
@RequestMapping
public class RegistrationController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserModelAssembler userModelAssembler;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User registeredUser = userService.createUser(user);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(registeredUser.getEmail());
        //final String jwt = jwtUtil.generateToken(userDetails);
        //User user = new User(registerUserRequest.getUsername(), registerUserRequest.getPassword());
        
        try {
            List<String> userRoles = new ArrayList<>();
            userRoles.add("USER");
            user.setUserRoles(userRoles);
            
            EntityModel<User> entityModel = userModelAssembler.toModel(userService.createUser(user));
            return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
            
        } catch (Exception e) {
            // Return an error response in case of failure
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
            
}