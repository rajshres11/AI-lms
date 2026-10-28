package com.org.ailms.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.ApiResponse;
import com.org.ailms.dto.LoginRequest;
import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/auth")
@RequiredArgsConstructor 
public class AuthController {

    private final AuthService authService;
    
    @PostMapping ("/register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody UserRequest ur){
       UserResponse urs =  authService.registerUser(ur);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "User created sussesfully",urs),HttpStatus.CREATED);
    }

    @PostMapping ("/login")
    public String login(@Valid @RequestBody LoginRequest lr){
      String token =   authService.login(lr);
        return token;
    }
}
