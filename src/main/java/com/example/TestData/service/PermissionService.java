package com.example.TestData.service;

import com.example.TestData.dto.request.PermissionRequest;
import com.example.TestData.dto.response.PermissionResponse;
import com.example.TestData.entity.Permission;
import com.example.TestData.mapper.PermisssionMapper;
import com.example.TestData.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermisssionMapper permisssionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permisssionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permisssionMapper.toPermissionResponse(permission);

    }

    public List<PermissionResponse> getAll(){
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permisssionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}



