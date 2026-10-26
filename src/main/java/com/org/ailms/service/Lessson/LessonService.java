package com.org.ailms.service.Lessson;

import java.util.List;

import com.org.ailms.dto.LessonRequest;
import com.org.ailms.dto.LessonResponse;

public interface LessonService {
    public LessonResponse addLessonToCourse(Long courseId,LessonRequest lr);
    public List<LessonResponse> getAllLessons();
    public LessonResponse getLessonById(Long lessonId);
    public LessonResponse updateLesson(Long lessonId,LessonRequest lr);
    public void deleteLesson(Long lessonId);
    public List<LessonResponse> getLessonByCourseId(Long courseId);
}
