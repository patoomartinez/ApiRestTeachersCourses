package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;

@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements CourseDao {

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().persist(course);
	}

	@Override
	public void deleteCourseById(Long idCourse) {
		// TODO Auto-generated method stub
		Course course = findById(idCourse);
		if (course != null) {
			getSession().delete(course);
		}
	}

	@Override
	public void updateCourse(Course course) {
		getSession().update(course);

	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return (Course) getSession().get(Course.class, id);
	}

	@Override
	public Course findByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery("from Course where name = :name ").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public List<Course> findCourseByTeacherId(Long idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery("from Course c join c.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}

}
