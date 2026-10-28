package com.org.ailms.service.Course;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.ailms.dto.CourseRequest;
import com.org.ailms.dto.CourseResponse;

public interface CourseService {
    public CourseResponse createCourse(CourseRequest cr);
    // public List<CourseResponse> getAllCourses();
    public Page<CourseResponse> getAllCourses(Pageable pageable);
    public CourseResponse getCourseById(Long courseId);
    public CourseResponse updateCourse(Long courseId,CourseRequest cr);
    public void deleteCourse(Long courseId);
    public Page<CourseResponse> searchCourses(String keyword, Pageable pageable);
}
