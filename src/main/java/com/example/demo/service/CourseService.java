package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseService {
	void saveCourse(Course course);

	void deleteCourseById(Long idCourse);

	void updateCourse(Course course);

	List<Course> findAllCourses();

	Course findById(Long id);

	Course findByName(String name);

	List<Course> findCourseByTeacherId(Long idTeacher);
}
