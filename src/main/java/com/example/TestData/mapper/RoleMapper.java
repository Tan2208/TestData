package com.example.TestData.mapper;

import com.example.TestData.dto.request.PermissionRequest;
import com.example.TestData.dto.request.RoleRequest;
import com.example.TestData.dto.response.PermissionResponse;
import com.example.TestData.dto.response.RoleResponse;
import com.example.TestData.entity.Permission;
import com.example.TestData.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target ="permission",ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

}
