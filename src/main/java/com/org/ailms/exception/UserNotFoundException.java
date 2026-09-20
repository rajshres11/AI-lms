package com.org.ailms.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User is not available");
    }
}
