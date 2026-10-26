package com.org.ailms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="lessons")
@Getter 
@Setter 
public class Lesson {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long lessonId;
    private String title;
    private String content;
    private String videoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne 
    @JoinColumn (name = "course_id",nullable = false)
    private Course course;
}
