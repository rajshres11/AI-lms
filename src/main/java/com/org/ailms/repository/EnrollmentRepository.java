package com.org.ailms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ailms.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // EnrollmentRepository.java
    List<Enrollment> findByStudent_UserId(Long userId);

    boolean existsByStudent_UserIdAndCourse_CourseId(Long userId,Long courseId);
}
