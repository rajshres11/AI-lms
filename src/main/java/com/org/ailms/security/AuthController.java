package com.org.ailms.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.LoginRequest;
import com.org.ailms.dto.UserRequest;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/auth")
@RequiredArgsConstructor 
public class AuthController {

    private final AuthService authService;
    
    @PostMapping ("/register")
    public String registerUser(@RequestBody UserRequest ur){
        authService.registerUser(ur);
        return "User is sussesfully register";
    }

    @PostMapping ("/login")
    public String login(@RequestBody LoginRequest lr){
        authService.login(lr);
        return "Logged in";
    }
}
