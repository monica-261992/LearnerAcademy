package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.SubjectClassTeacher;

public interface SubjectClassTeacherDao {

	void insert(SubjectClassTeacher obj);
	List<SubjectClassTeacher> getAll();
	void update(SubjectClassTeacher obj);
}

