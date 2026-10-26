package com.org.ailms.dto;

import com.org.ailms.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter 
public class EnrollmentRequest {
    private Long userId;
    private Long courseId;
}
