package com.example.TestData.service;

import com.example.TestData.Exception.AppException;
import com.example.TestData.Exception.ErrorCode;
import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.dto.request.UserUpdateRequest;
import com.example.TestData.dto.response.UserResponse;
import com.example.TestData.entity.User;
import com.example.TestData.mapper.UserMapper;
import com.example.TestData.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {


    UserRepository userRepository;
    UserMapper userMapper;

    public User createRequest(UserCreationRequest request){
        //User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);

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

