package com.org.ailms.entity;

import java.time.LocalDateTime;

import com.org.ailms.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@Table (name = "enrollment")
public class Enrollment {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    private LocalDateTime enrolledAt;
    @Enumerated (EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne 
    @JoinColumn (name = "student_id",nullable = false)
    private User student;

    @ManyToOne 
    @JoinColumn (name = "course_id",nullable = false)
    private Course course;
}
