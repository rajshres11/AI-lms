package com.org.ailms.service.Lessson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.ailms.dto.LessonRequest;
import com.org.ailms.dto.LessonResponse;
import com.org.ailms.entity.Course;
import com.org.ailms.entity.Lesson;
import com.org.ailms.exception.CourseNotFoundException;
import com.org.ailms.exception.LessonNotFoundException;
import com.org.ailms.repository.CourseRepository;
import com.org.ailms.repository.LessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonServiceImp implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Override 
    @Transactional 
    public LessonResponse addLessonToCourse(Long courseId,LessonRequest lr) {
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new CourseNotFoundException());
        Lesson lesson = new Lesson();
        lesson.setTitle(lr.getTitle());
        lesson.setContent(lr.getContent());
        lesson.setVideoUrl(lr.getVideoUrl());
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setCourse(course);

        Lesson saved = lessonRepository.save(lesson);

        LessonResponse lrs = new LessonResponse();
        lrs.setLessonId(saved.getLessonId());
        lrs.setTitle(saved.getTitle());
        lrs.setContent(saved.getContent());
        lrs.setVideoUrl(saved.getVideoUrl());
        lrs.setCreatedAt(saved.getCreatedAt());

        return lrs;
    }
    
    @Override 
    public List<LessonResponse> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonResponse> lList = new ArrayList<>();
        for (Lesson l : lessons) {
            LessonResponse lrs = new LessonResponse();
            lrs.setLessonId(l.getLessonId());
            lrs.setTitle(l.getTitle());
            lrs.setContent(l.getContent());
            lrs.setVideoUrl(l.getVideoUrl());
            lrs.setCreatedAt(l.getCreatedAt());
            lList.add(lrs);
        }
        return lList;
    }

    @Override 
    public LessonResponse getLessonById(Long lessonId){
        Lesson saved = lessonRepository.findById(lessonId).orElseThrow(()->new LessonNotFoundException());
        LessonResponse lrs = new LessonResponse();
        lrs.setLessonId(saved.getLessonId());
        lrs.setTitle(saved.getTitle());
        lrs.setContent(saved.getContent());
        lrs.setVideoUrl(saved.getVideoUrl());
        lrs.setCreatedAt(saved.getCreatedAt());
        return lrs;
    }

    @Override 
    public LessonResponse updateLesson(Long lessonId,LessonRequest lr){
        Lesson saved = lessonRepository.findById(lessonId).orElseThrow(()-> new LessonNotFoundException());
        saved.setTitle(lr.getTitle());
        saved.setContent(lr.getContent());
        saved.setVideoUrl(lr.getVideoUrl());
        saved.setUpdatedAt(LocalDateTime.now());
        
        Lesson updated = lessonRepository.save(saved);
        LessonResponse lrs = new LessonResponse();
        lrs.setLessonId(updated.getLessonId());
        lrs.setTitle(updated.getTitle());
        lrs.setContent(updated.getContent());
        lrs.setVideoUrl(updated.getVideoUrl());
        lrs.setUpdatedAt(updated.getUpdatedAt());
        return lrs;
    }
    
    @Override 
    public void deleteLesson(Long lessonId){
        lessonRepository.deleteById(lessonId);
    }


    @Override 
    public List<LessonResponse> getLessonByCourseId(Long courseId){
        List<Lesson> lessons = lessonRepository.findByCourse_CourseId(courseId);

        List<LessonResponse> lList = new ArrayList<>();
        for (Lesson l : lessons) {
            LessonResponse lrs = new LessonResponse();
            lrs.setLessonId(l.getLessonId());
            lrs.setTitle(l.getTitle());
            lrs.setContent(l.getContent());
            lrs.setVideoUrl(l.getVideoUrl());
            lrs.setCreatedAt(l.getCreatedAt());
            lList.add(lrs);
        }
        return lList;
    }
}
