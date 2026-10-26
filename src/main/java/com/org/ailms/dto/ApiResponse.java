package com.org.ailms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Getter 
@Setter 
public class ApiResponse<T> {
    private Integer value;
    private String message;
    private T data;
}
