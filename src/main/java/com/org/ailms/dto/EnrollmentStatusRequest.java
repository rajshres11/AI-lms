package com.org.ailms.dto;

import com.org.ailms.enums.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class EnrollmentStatusRequest {
    @Enumerated (EnumType.STRING)
    private Status status;
}
