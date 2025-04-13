package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.dev.model.UserModels.User;
import com.dev.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    public boolean verifyLogin(String email, String password) {
        // Find user by email
        try{
            User user = userRepository.findByEmail(email);
        
            // Compare the password with the stored hash
            return passwordEncoder.matches(password, user.getPassword());
        }
        catch(Exception e){
            return false;  // User not found
        }
    }

    public User createUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean DeleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public User replaceUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

