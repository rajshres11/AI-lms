package com.org.ailms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.ApiResponse;
import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;
import com.org.ailms.service.User.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserResponse>> addUser(@RequestBody UserRequest req) {
        UserResponse res = userService.createUser(req);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "User created", res),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        List<UserResponse> userList = userService.getAllUsers();

        ApiResponse<List<UserResponse>> res = new ApiResponse<List<UserResponse>>(HttpStatus.OK.value(),
                "All users data", userList);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> findByUserId(@PathVariable Long userId) {
        UserResponse res = userService.getUserById(userId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "User data fetched", res), HttpStatus.OK);
    }

    @PutMapping ("/update/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable Long userId,
            @RequestBody UserRequest req) {
        UserResponse res = userService.updateUser(userId, req);

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "User updated", res), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "User deleted", null),
                HttpStatus.NO_CONTENT);
    }
}
