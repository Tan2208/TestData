package com.example.TestData.mapper;

import com.example.TestData.dto.request.PermissionRequest;
import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.dto.request.UserUpdateRequest;
import com.example.TestData.dto.response.PermissionResponse;
import com.example.TestData.dto.response.UserResponse;
import com.example.TestData.entity.Permission;
import com.example.TestData.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PermisssionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
