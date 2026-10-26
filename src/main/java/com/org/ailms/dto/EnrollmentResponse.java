package com.org.ailms.dto;

import java.time.LocalDateTime;

import com.org.ailms.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class EnrollmentResponse {
    private Long enrollmentId;
    private LocalDateTime enrolledAt;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long studetnId;
    private Long courseId;
}
