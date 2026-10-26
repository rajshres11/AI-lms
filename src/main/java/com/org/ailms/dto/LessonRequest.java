package com.org.ailms.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LessonRequest {
    @NotNull 
    @NotBlank 
    private String title;
    private String content;
    private String videoUrl;
}
