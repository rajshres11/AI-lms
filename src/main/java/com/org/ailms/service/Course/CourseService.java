package com.org.ailms.service.Course;

import java.util.List;

import com.org.ailms.dto.CourseRequest;
import com.org.ailms.dto.CourseResponse;

public interface CourseService {
    public CourseResponse createCourse(CourseRequest cr);
    public List<CourseResponse> getAllCourses();
    public CourseResponse getCourseById(Long courseId);
    public CourseResponse updateCourse(Long courseId,CourseRequest cr);
    public void deleteCourse(Long courseId);
}
