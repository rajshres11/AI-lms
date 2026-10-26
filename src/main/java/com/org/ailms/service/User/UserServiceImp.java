package com.org.ailms.service.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;
import com.org.ailms.entity.User;
import com.org.ailms.enums.Role;
import com.org.ailms.exception.UserNotFoundException;
import com.org.ailms.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override 
    public List<UserResponse> getAllUsers() {
        List<User> savedUsers = userRepository.findAll();

        List<UserResponse> resList = new ArrayList<>();
        for (User saved : savedUsers) {
            UserResponse res = new UserResponse();
            res.setUserId(saved.getUserId());
            res.setName(saved.getName());
            res.setEmail(saved.getEmail());
            res.setPhone(saved.getPhone());
            String role = saved.getRole().toString();
            res.setRole(role);

            resList.add(res);
        }
        return resList;
    }

    @Override
    public UserResponse getUserById(Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        User saved = userRepository.findByEmail(username).orElseThrow(()-> new UserNotFoundException());

        if(saved.getRole().equals(Role.STUDENT)){
            if(!saved.getUserId().equals(userId)){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"You cant access antoher user data");
            }
        }
        UserResponse res = new UserResponse();
        res.setUserId(saved.getUserId());
        res.setName(saved.getName());
        res.setEmail(saved.getEmail());
        String role = saved.getRole().toString();
        res.setRole(role);
        return res;
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest req) {
        User saved = userRepository.findById(userId)
                        .orElseThrow(() -> new UserNotFoundException());
        saved.setName(req.getName());
        saved.setEmail(req.getEmail());
        saved.setPassword(passwordEncoder.encode(req.getPassword()));
        saved.setPhone(req.getPhone());
        saved.setRole(Role.STUDENT);
        saved.setUpdatedAt(LocalDateTime.now());

        User updated = userRepository.save(saved);

        UserResponse res = new UserResponse();
        res.setUserId(userId);
        res.setName(updated.getName());
        res.setEmail(updated.getEmail());
        res.setPhone(updated.getPhone());
        res.setRole("STUDENT");
        res.setUpdatedAt(updated.getUpdatedAt());
        return res;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
