package com.org.ailms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ailms.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long>{
    List<Lesson> findByCourse_CourseId(Long courseId);
}
