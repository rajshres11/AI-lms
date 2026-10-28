package com.org.ailms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CourseRequest {
    @NotBlank (message = "Title must be there")
    @NotNull (message = "Title must be there")
    private String title;
    @NotBlank (message = "Atleast 10 words has to be write")
    @Size (min = 10,max = 1000)
    private String description;
    @PositiveOrZero (message = "Insert value 0 or more than 0")
    private Double price;
}
