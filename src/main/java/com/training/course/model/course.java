package com.training.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long courseId;
	
	private String courseName;
	
	private int courseDuration;
	
	
	public course ( int courseDuration, int courseId, String courseName) {
		this.courseDuration = courseDuration;
		this.courseId = courseId;
		this.courseName = courseName;
	}
	

}
