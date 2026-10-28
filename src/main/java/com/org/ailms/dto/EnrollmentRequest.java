package com.org.ailms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter 
@Getter 
public class EnrollmentRequest {
    // @NotBlank (message = "Course id is compulsury")
    // @NotEmpty (message = "Course id is compulsury")
    // @NonNull 
    private Long courseId;
}
