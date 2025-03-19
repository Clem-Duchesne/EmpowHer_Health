package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.controller.RequiredArgsConstructor;
import com.dev.model.UserModels.User;
import com.dev.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    public User createUser(User user)
    {
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
}
