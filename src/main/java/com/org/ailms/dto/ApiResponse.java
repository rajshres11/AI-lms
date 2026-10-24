package com.org.ailms.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class ApiResponse<T> {
    private Integer value;
    private String message;
    private T data;
}
