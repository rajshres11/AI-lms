package com.org.ailms.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name = "courses")
@Getter 
@Setter 
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column (unique = true,nullable = false)
    private String title;
    private String description;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;   
    
    @OneToMany (mappedBy = "course")
    private List<Lesson> lessons;

    @OneToMany 
    private List<Enrollment> enrollments;
}
