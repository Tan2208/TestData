package com.example.TestData.service;

import com.example.TestData.Exception.AppException;
import com.example.TestData.Exception.ErrorCode;
import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.dto.request.UserUpdateRequest;

import com.example.TestData.entity.User;
import com.example.TestData.enums.Role;
import com.example.TestData.mapper.UserMapper;
import com.example.TestData.repository.UserRepository;
import lombok.AccessLevel;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {


    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public User createRequest(UserCreationRequest request){
        //User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(roles);

        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    public UserRepository updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
        userMapper.updateUser(user,request);
        return (UserRepository) userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


}

