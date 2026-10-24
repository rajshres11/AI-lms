package com.org.ailms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CourseRequest {
    @NotBlank 
    @NotNull 
    private String title;
    private String description;
    @Positive 
    private Double price;
}
