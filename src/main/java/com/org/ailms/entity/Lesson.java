package com.org.ailms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
    @Column (unique = true,nullable = false)
    private String title;
    @Column (nullable = false)
    private String content;
    @Column (unique = true,nullable = false)
    private String videoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne 
    @JoinColumn (name = "course_id",nullable = false)
    private Course course;
}
