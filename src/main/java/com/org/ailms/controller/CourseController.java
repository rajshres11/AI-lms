package com.org.ailms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.ApiResponse;
import com.org.ailms.dto.CourseRequest;
import com.org.ailms.dto.CourseResponse;
import com.org.ailms.service.Course.CourseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping ("/api/v1/course")
@RequiredArgsConstructor 
public class CourseController {
    private final CourseService courseService;

    @PostMapping ("/create")
    public ResponseEntity<ApiResponse<CourseResponse>> createCourse(@RequestBody CourseRequest cr){
        CourseResponse crs = courseService.createCourse(cr);
        return new ResponseEntity<>(new ApiResponse<CourseResponse>(HttpStatus.CREATED.value(), "Course created",crs ),HttpStatus.CREATED);
    }

    @GetMapping ("/getall")
    public ResponseEntity<ApiResponse<List<CourseResponse>>> getAllCourses(){
        List<CourseResponse> crsList = courseService.getAllCourses();
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Courses fetched",crsList ),HttpStatus.OK);
    }

    @GetMapping ("/get/{courseId}")
    public ResponseEntity<ApiResponse<CourseResponse>> getCourseById(@PathVariable Long courseId){
        CourseResponse crs = courseService.getCourseById(courseId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Course fetched",crs ),HttpStatus.OK);
    }

    @PutMapping ("/update/{courseId}")
    public ResponseEntity<ApiResponse<CourseResponse>> updateCourse(@PathVariable Long courseId,@RequestBody CourseRequest cr){
        CourseResponse crs = courseService.updateCourse(courseId, cr);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Course updated",crs ),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Course deleted", null),
                HttpStatus.NO_CONTENT);
    }
}
