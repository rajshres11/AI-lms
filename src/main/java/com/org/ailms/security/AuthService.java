package com.org.ailms.security;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.ailms.dto.LoginRequest;
import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;
import com.org.ailms.entity.User;
import com.org.ailms.enums.Role;
import com.org.ailms.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserResponse registerUser(UserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setPhone(req.getPhone());
        user.setRole(Role.STUDENT);
        
        user.setCreatedAt(LocalDateTime.now());
        User saved = userRepository.save(user);

        UserResponse res = new UserResponse();
        res.setUserId(saved.getUserId());
        res.setName(saved.getName());
        res.setEmail(saved.getEmail());
        res.setPhone(saved.getPhone());
        res.setRole("STUDENT");
        res.setCreatedAt(saved.getCreatedAt());
        return res;

    }

    public String login(LoginRequest lr){
        Authentication authentication = authenticationManager.authenticate(
           new  UsernamePasswordAuthenticationToken(lr.getEmail(),lr.getPassword())
        );
        String token = jwtService.generateToken((UserDetails) Objects.requireNonNull(authentication.getPrincipal()));
        return token;
    }
}
