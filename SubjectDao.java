package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.lms.entities.Subject;

public interface SubjectDao {
	
	void insert(Subject subject);
	List<Subject> getAll();
	Subject getSubject(int id);
	void update(Subject subject);
	
}
