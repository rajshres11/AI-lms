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
    @NotEmpty (message = "Name is mandatory")
    private String name;
    @Email 
    @NotBlank (message = "Email is mandatory")
    @NotNull 
    private String email;
    @NotNull 
    @NotBlank (message = "password is mandatory")
    private String password;
    @NotNull 
    @NotBlank 
    @NotEmpty (message = "phone number is mandatory")
    private String phone;
}
