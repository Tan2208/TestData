package com.example.TestData.service;

import com.example.TestData.entity.User;
import com.example.TestData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createRequest(Object request){
        return null;
    }
}

