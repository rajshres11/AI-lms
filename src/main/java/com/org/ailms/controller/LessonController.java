package com.org.ailms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ailms.dto.ApiResponse;
import com.org.ailms.dto.LessonRequest;
import com.org.ailms.dto.LessonResponse;
import com.org.ailms.service.Lessson.LessonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping("/addLessonToCourse/{courseId}")
    public ResponseEntity<ApiResponse<LessonResponse>> createLesson(@PathVariable Long courseId,
           @Valid @RequestBody LessonRequest lr) {

        LessonResponse lrs = lessonService.addLessonToCourse(courseId,lr);

        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.CREATED.value(), "Lesson created", lrs),
                HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<LessonResponse>>> getAllLessons() {

        List<LessonResponse> lList = lessonService.getAllLessons();

        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(), "Lessons fetched", lList),
                HttpStatus.OK);
    }

    @GetMapping("/get/{lessonId}")
    public ResponseEntity<ApiResponse<LessonResponse>> getLessonById(
            @PathVariable Long lessonId) {

        LessonResponse lrs = lessonService.getLessonById(lessonId);

        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(), "Lesson fetched", lrs),
                HttpStatus.OK);
    }

    @PutMapping("/update/{lessonId}")
    public ResponseEntity<ApiResponse<LessonResponse>> updateLesson(
            @PathVariable Long lessonId,
           @Valid @RequestBody LessonRequest lr) {

        LessonResponse lrs = lessonService.updateLesson(lessonId, lr);

        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(), "Lesson updated", lrs),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{lessonId}")
    public ResponseEntity<ApiResponse<String>> deleteLesson(
            @PathVariable Long lessonId) {

        lessonService.deleteLesson(lessonId);

        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Lesson deleted", null),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping ("/getlessonbycourseid/{courseId}")
    public ResponseEntity<ApiResponse<List<LessonResponse>>> getLessonsByCourseId(
        @PathVariable Long courseId){
        List<LessonResponse> lrs = lessonService.getLessonByCourseId(courseId);
        return  new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),"All lessons", lrs),HttpStatus.OK);
    }
}
