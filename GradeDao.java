package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.Subject;

public interface GradeDao {
	
	void insert(Grade grade);
	List<Grade> getAll();
	Grade get(int gid);
	void update(Grade grade);
	void assignSubject(Grade grade,String[] subjects);
}
