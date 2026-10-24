package com.org.ailms.dto;

import java.time.LocalDateTime;

import com.org.ailms.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    @Enumerated (EnumType.STRING)
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


