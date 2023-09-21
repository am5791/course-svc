package com.training.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.training.course.intercomm.StudentClient;
import com.training.course.model.Student;
import com.training.course.model.course;
import com.training.course.repository.CourseRepository;

//import antlr.collections.List;


@RestController
@RequestMapping("/courseapi")

public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentClient studClient;
	
	
	@GetMapping("/cour")
	public ResponseEntity<List<course>> getcour() {
		
		List<course> courList = repository.findAll();
		
		return new ResponseEntity<>(courList, HttpStatus.OK);
//		return repository.findAll();
	}
	
	//response indetity is a class which returns the http status code along with
	
	
	
	@PostMapping("/post")
	public void post(@RequestBody course cour) {
		repository.save(cour);
	}
	
	@GetMapping("cour/{id}")
	public course getStudentById(@PathVariable("id") long id) {
		
		Optional<course> cour = repository.findById(id);
		
		if(cour.isPresent()) {
			return cour.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/cour/{id}")
	public void updateUser(@PathVariable("id") long id, @RequestBody course cour) {
	Optional<course> oldData = repository.findById(id);
	
	if(oldData.isPresent()) {
		course cor = oldData.get();
		
		cor.setCourseName(cour.getCourseName());
		//cor.setCourseId(cour.getCourseId());
		cor.setCourseDuration(cour.getCourseDuration());
		
		repository.save(cor);
	}
	else {
		System.out.println("No Data Found");
	}
	}
	
	@GetMapping("/service/stud/{studId}")
	public Student getStud(@PathVariable long studId) {
		return studClient.getStudent(studId);
	}
	
	
}
