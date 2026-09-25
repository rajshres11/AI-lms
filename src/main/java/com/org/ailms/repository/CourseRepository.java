package com.org.ailms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ailms.entity.Course;

public interface  CourseRepository extends JpaRepository<Course,Long>{
    
}
