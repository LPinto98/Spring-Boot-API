package com.larissa.WebProject.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larissa.WebProject.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

}
