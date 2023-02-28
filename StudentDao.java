package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.Student;

public interface StudentDao {

	void insert(Student student);
	List<Student> getAll();
	List<Student> getStudent(int gradeId);
	
}
