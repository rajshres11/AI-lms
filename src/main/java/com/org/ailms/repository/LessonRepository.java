package com.org.ailms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.ailms.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourse_CourseId(Long courseId);

    @Query("SELECT COALESCE(MAX(l.sequenceNumber), 0) " +
            "FROM Lesson l WHERE l.course.courseId = :courseId")
    Integer findMaxSequenceByCourseId(Long courseId);

    List<Lesson> findByCourse_CourseIdOrderBySequenceNumberAsc(Long courseId);
}
