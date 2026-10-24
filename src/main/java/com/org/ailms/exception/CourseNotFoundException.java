package com.org.ailms.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Course is not a available");
    }
}
