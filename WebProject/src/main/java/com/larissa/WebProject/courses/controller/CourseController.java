package com.larissa.WebProject.courses.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.larissa.WebProject.courses.bean.Course;
import com.larissa.WebProject.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return repository.findAll();
		//return Arrays.asList(new Course(1,"Learn Microservices","Larissa"), 
//				new Course(2,"Learn Java Spring Boot", "IBM"),
//				new Course(3,"Learn MVC","Udemy"));
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse1(@PathVariable long id) {
		Optional<Course> course =  repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course with id "+id+" not found");
		}
		return course.get();
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PutMapping("/courses/{id}")
	public void UpdateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void DeleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
