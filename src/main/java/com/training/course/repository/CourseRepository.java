package com.training.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.course.model.course;


public interface CourseRepository extends JpaRepository<course, Long> {
	
	
}

