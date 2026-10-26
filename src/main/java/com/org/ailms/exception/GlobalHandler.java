package com.org.ailms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalHandler {
    
    @ExceptionHandler (UserNotFoundException.class)
    public ResponseEntity<String> UserNotFoundExceptionHandler(UserNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (CourseNotFoundException.class)
    public ResponseEntity<String> CourseNotFoundExceptionHandler(CourseNotFoundException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<String> 
    RuntimeExceptionHandler(RuntimeException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler (LessonNotFoundException.class)
    public ResponseEntity<String> LessonNotFoundExceptionHandler(LessonNotFoundException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

}
