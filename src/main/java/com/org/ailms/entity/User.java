package com.org.ailms.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.org.ailms.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="users")
@Getter 
@Setter 
public class User {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column (nullable = false)
    private String name;
    @Email 
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private String phone;
    @Enumerated (EnumType.STRING)
    private Role role;
    @Column (nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany (mappedBy = "student")
    private List<Enrollment> enrollments;
}
