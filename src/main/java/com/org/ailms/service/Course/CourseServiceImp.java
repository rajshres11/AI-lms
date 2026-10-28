package com.org.ailms.service.Course;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.org.ailms.dto.CourseRequest;
import com.org.ailms.dto.CourseResponse;
import com.org.ailms.entity.Course;
import com.org.ailms.exception.CourseNotFoundException;
import com.org.ailms.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest cr) {
        Course course = new Course();
        course.setTitle(cr.getTitle());
        course.setDescription(cr.getDescription());
        course.setPrice(cr.getPrice());
        course.setCreatedAt(LocalDateTime.now());

        Course saved = courseRepository.save(course);
        CourseResponse crs = new CourseResponse();
        crs.setCourseId(saved.getCourseId());
        crs.setTitle(saved.getTitle());
        crs.setDescription(saved.getDescription());
        crs.setPrice(saved.getPrice());
        crs.setCreatedAt(saved.getCreatedAt());
        return crs;
    }

    @Override
    public Page<CourseResponse> getAllCourses(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        List<CourseResponse> resList = new ArrayList<>();
        for (Course c : courses.getContent()) {
            CourseResponse crs = new CourseResponse();
            crs.setCourseId(c.getCourseId());
            crs.setTitle(c.getTitle());
            crs.setDescription(c.getDescription());
            crs.setPrice(c.getPrice());
            resList.add(crs);
        }
        return new PageImpl<>(
            resList,
            pageable,
            courses.getTotalElements()
        );
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        Course saved = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());

        CourseResponse crs = new CourseResponse();
        crs.setCourseId(saved.getCourseId());
        crs.setTitle(saved.getTitle());
        crs.setDescription(saved.getDescription());
        crs.setPrice(saved.getPrice());
        return crs;
    }

    @Override
    public CourseResponse updateCourse(Long courseId, CourseRequest cr) {
        Course saved = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());

        saved.setTitle(cr.getTitle());
        saved.setDescription(cr.getDescription());
        saved.setPrice(cr.getPrice());
        saved.setUpdatedAt(LocalDateTime.now());

        Course updated = courseRepository.save(saved);
        CourseResponse crs = new CourseResponse();
        crs.setCourseId(courseId);
        crs.setTitle(updated.getTitle());
        crs.setDescription(updated.getDescription());
        crs.setPrice(updated.getPrice());
        crs.setUpdatedAt(updated.getUpdatedAt());
        return crs;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override 
    public Page<CourseResponse> searchCourses(String keyword, Pageable pageable) {
        Page<Course> courses = courseRepository.findByTitleContainingIgnoreCase(keyword, pageable);
        List<CourseResponse> responseList = new ArrayList<>();

        for (Course course : courses.getContent()) {

            CourseResponse crs = new CourseResponse();

            crs.setCourseId(course.getCourseId());
            crs.setTitle(course.getTitle());
            crs.setDescription(course.getDescription());
            crs.setPrice(course.getPrice());
            crs.setCreatedAt(course.getCreatedAt());
            crs.setUpdatedAt(course.getUpdatedAt());

            responseList.add(crs);
        }

        return new PageImpl<>(
                responseList,
                pageable,
                courses.getTotalElements());
    }
}
