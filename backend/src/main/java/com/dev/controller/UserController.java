package com.dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.dev.exception.UserNotFoundException;
import com.dev.model.UserModels.User;
import com.dev.services.UserService;
import com.dev.modelassembler.UserModelAssembler;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserModelAssembler userModelAssembler;
    
    @GetMapping("/users")
    public CollectionModel<EntityModel<User>> getUsers() {
        List<EntityModel<User>> users = userService.getUsers().stream()
            .map(userModelAssembler::toModel) //
            .collect(Collectors.toList());
      
        return CollectionModel.of(users, linkTo(methodOn(UserController.class).getUsers()).withSelfRel());
      }
    
    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id)
        .orElseThrow(() -> new UserNotFoundException(id));

        return userModelAssembler.toModel(user);
    }
    
    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

        userService.DeleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            // Initialize userRoles and set the default role
            if (user.getUserRoles() == null || user.getUserRoles().isEmpty()) {
                List<String> userRoles = new ArrayList<>();
                userRoles.add("USER");
                user.setUserRoles(userRoles);
            }
            EntityModel<User> entityModel = userModelAssembler.toModel(userService.createUser(user));
        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
            .body(entityModel);
            
        } catch (Exception e) {
            // Return an error response in case of failure
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        
    }

    @PutMapping("/employees/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

    User updatedUser = userService.getUserById(id)
        .map(user -> {
                user.setEmail(newUser.getEmail());
                user.setUserRoles(newUser.getUserRoles());
                user.setPassword(newUser.getPassword());
                return userService.replaceUser(user);
            })
        .orElseGet(() -> {
            return userService.createUser(newUser);
        });

    EntityModel<User> entityModel = userModelAssembler.toModel(updatedUser);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
    }
    
}