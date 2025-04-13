package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.UserModels.User;
import com.dev.requests.LoginRequest;
import com.dev.responses.JwtResponse;
import com.dev.services.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user
            boolean isValid = userService.verifyLogin(loginRequest.getUsername(), loginRequest.getPassword());
            if(isValid){
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                );
                return ResponseEntity.ok(token);
            }
            return ResponseEntity.status(401).body("Invalid credentials"); 
            
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid credentials");  // Invalid credentials response
        }
    }
}
