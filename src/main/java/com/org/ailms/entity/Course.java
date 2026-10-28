package com.org.ailms.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
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
    @Column (nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;   
    
    @OneToMany (mappedBy = "course",cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @OneToMany (mappedBy = "course")
    private List<Enrollment> enrollments;
}
