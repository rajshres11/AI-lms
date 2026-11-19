package com.org.ailms.service.User;

import java.util.List;

import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;

public interface UserService {
    public List<UserResponse> getAllUsers();
    public UserResponse getUser();
    public UserResponse updateUser(UserRequest req);
    public void deleteUser(Long userId);
}
