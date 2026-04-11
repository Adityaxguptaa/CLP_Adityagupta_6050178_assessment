package com.example.user_service.service;

import org.springframework.stereotype.Service;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.model.User;

@Service
public class UserService {

    private final UserRepository repo;

 
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User saveUser(User user) {
        return repo.save(user);
    }
}