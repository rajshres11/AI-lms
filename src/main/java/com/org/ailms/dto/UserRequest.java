package com.org.ailms.dto;

import java.time.LocalDateTime;

import com.org.ailms.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class UserRequest {
    @NotNull 
    private String name;
    @Email 
    @Column (nullable = false,unique = true)
    private String email;
    private String password;
    private String phone;
    @Enumerated (EnumType.STRING)
    private Role role;
}
