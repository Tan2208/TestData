package com.example.TestData.controller;

import com.example.TestData.dto.request.ApiResponse;
import com.example.TestData.dto.request.PermissionRequest;
import com.example.TestData.dto.request.RoleRequest;
import com.example.TestData.dto.response.PermissionResponse;
import com.example.TestData.dto.response.RoleResponse;
import com.example.TestData.entity.Role;
import com.example.TestData.service.PermissionService;
import com.example.TestData.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }


    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return  ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();

    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }

}
