package com.org.ailms.dto;

import java.time.LocalDateTime;

import com.org.ailms.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class UserRequest {
    @NotNull 
    private String name;
    @Email 
    @NotBlank 
    @NotNull 
    private String email;
    @NotNull 
    @NotBlank 
    private String password;
    private String phone;
    @NotEmpty 
    @Enumerated (EnumType.STRING)
    private Role role;
}
