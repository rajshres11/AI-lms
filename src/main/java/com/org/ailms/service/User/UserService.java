package com.org.ailms.service.User;

import com.org.ailms.dto.UserRequest;
import com.org.ailms.dto.UserResponse;

public interface UserService {
    public UserResponse addUser(UserRequest req);
    public UserResponse findUserById(Long userId);
    public String deleteUser(Long userId);
}
