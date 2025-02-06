package com.example.TestData.mapper;

import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.dto.request.UserUpdateRequest;
import com.example.TestData.dto.response.UserResponse;
import com.example.TestData.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper{
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
