package com.org.ailms.service.User;

import org.springframework.stereotype.Service;

import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;
import com.org.ailms.entity.User;
import com.org.ailms.exception.UserNotFoundException;
import com.org.ailms.repository.UserRepository;

@Service 
public class UserServiceImp implements UserService{
    
    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override 
    public UserResponse addUser(UserRequest req){
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setRole(req.getRole());
        User saved = userRepository.save(user);

        UserResponse res = new UserResponse();
        res.setUserId(saved.getUserId());
        res.setName(saved.getName());
        res.setEmail(saved.getEmail());
        res.setPhone(saved.getPhone());
        res.setRole(saved.getRole());
        res.setCreatedAt(saved.getCreatedAt());
        res.setUpdatedAt(saved.getUpdatedAt());
        return res;

    }

    @Override
    public UserResponse findUserById(Long userId){
        User saved = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
        UserResponse res = new UserResponse();
        res.setUserId(saved.getUserId());
        res.setName(saved.getName());
        res.setEmail(saved.getEmail());
        res.setPhone(saved.getPhone());
        res.setRole(saved.getRole());
        res.setCreatedAt(saved.getCreatedAt());
        res.setUpdatedAt(saved.getUpdatedAt());
        return res;
    }

    public String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return "User deleted";
    }
}
