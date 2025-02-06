package com.example.TestData.mapper;

import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper{
    User toUser(UserCreationRequest request);
}
