package com.org.ailms.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ailms.entity.Course;

public interface  CourseRepository extends JpaRepository<Course,Long>{
    Page<Course> findByTitleContainingIgnoreCase(String keyword,Pageable pageable);
}
