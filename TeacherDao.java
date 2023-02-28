package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.lms.entities.Teacher;

public interface TeacherDao {

	void insert(Teacher teacher);
	List<Teacher> getAll();
	Teacher get(int tid);
	
}