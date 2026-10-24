package com.org.ailms.service.Course;

import org.springframework.stereotype.Service;

import com.org.ailms.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class CourseServiceImp implements CourseService{
    private final CourseRepository courseRepository;

    public CourseResponse createCourse(CourseRequest courseRequest){
        
    }
}
