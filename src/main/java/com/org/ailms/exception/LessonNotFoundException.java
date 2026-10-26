package com.org.ailms.exception;

public class LessonNotFoundException extends RuntimeException{
    public LessonNotFoundException(){
        super("Lesson is not available");
    }
}
