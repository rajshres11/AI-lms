package com.org.ailms.service.User;

import java.util.List;

import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;

public interface UserService {
    public UserResponse createUser(UserRequest req);
    public List<UserResponse> getAllUsers();
    public UserResponse getUserById(Long userId);
    public UserResponse updateUser(Long userId,UserRequest req);
    public void deleteUser(Long userId);
}
