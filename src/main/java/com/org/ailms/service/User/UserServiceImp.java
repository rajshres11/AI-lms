package com.org.ailms.service.User;

import java.util.ArrayList;
import java.util.List;

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
    public UserResponse createUser(UserRequest req){
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
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
        return res;

    }

    public List<UserResponse> getAllUsers(){
        List<User> savedUsers = userRepository.findAll();
        
        List<UserResponse> resList = new ArrayList<>();
        for(User saved:savedUsers){
            UserResponse res = new UserResponse();
            res.setUserId(saved.getUserId());
            res.setName(saved.getName());
            res.setEmail(saved.getEmail());
            res.setPhone(saved.getPhone());
            res.setRole(saved.getRole());
            res.setCreatedAt(saved.getCreatedAt());

            resList.add(res);
        }
        return resList;
    }

    @Override
    public UserResponse getUserById(Long userId){
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

    @Override 
    public UserResponse updateUser(Long userId,UserRequest req){
        User saved = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
        saved.setName(req.getName());
        saved.setEmail(req.getEmail());
        saved.setPassword(req.getPassword());
        saved.setPhone(req.getPassword());
        saved.setRole(req.getRole());
        saved.setUpdatedAt(req.getUpdatedAt());

        User updated = userRepository.save(saved);

        UserResponse res = new UserResponse();
        res.setUserId(userId);
        res.setName(updated.getName());
        res.setEmail(updated.getEmail());
        res.setPhone(updated.getPhone());
        res.setRole(updated.getRole());

        return res;
    }

    @Override 
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
