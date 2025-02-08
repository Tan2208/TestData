package com.example.TestData.controller;

import com.example.TestData.dto.request.ApiResponse;
import com.example.TestData.dto.request.UserCreationRequest;
import com.example.TestData.dto.request.UserUpdateRequest;
import com.example.TestData.entity.User;
import com.example.TestData.repository.UserRepository;
import com.example.TestData.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request)
    {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username= {}",authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return userService.getUser();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    UserRepository updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deteled" ;
    }
}
