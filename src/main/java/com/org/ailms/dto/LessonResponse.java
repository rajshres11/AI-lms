package com.org.ailms.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LessonResponse {
    private Long lessonId;
    private String title;
    private String content;
    private String videoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

