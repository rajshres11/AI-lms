package com.org.ailms.dto;

public class ApiResponse<T> {
    private Integer value;
    private String message;
    private T data;
    public ApiResponse(Integer value, String message, T data) {
        this.value = value;
        this.message = message;
        this.data = data;
    }
    
}
