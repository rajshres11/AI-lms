package com.org.ailms.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class LessonRequest {
    @NotNull 
    @NotBlank (message = "Tite is compulsory")
    private String title;
    @NotBlank 
    @NotNull 
    @NotEmpty (message = "write minimum 100 words")
    @Size (min= 100,max = 2000)
    private String content;
    @NotNull 
    @NotBlank (message = "put video url here it is compulsory")
    private String videoUrl;
}
