package org.simplilearn.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.dao.GradeDao;
import org.simplilearn.dao.GradeDaoImpl;
import org.simplilearn.dao.SubjectDao;
import org.simplilearn.dao.SubjectDaoImpl;
import org.simplilearn.dao.TeacherDao;
import org.simplilearn.dao.TeacherDaoImpl;
import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;

public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private GradeDao dao = new GradeDaoImpl();
	 private SubjectDao subjectdao = new SubjectDaoImpl();
	 private TeacherDao teacherDao = new TeacherDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Grade> grades = dao.getAll();
		request.setAttribute("grades", grades);
		
		List<Subject> subjects = subjectdao.getAll();
		request.setAttribute("subjects", subjects);
		
		List<Teacher> teachers = teacherDao.getAll();
		request.setAttribute("teachers", teachers);
		
		RequestDispatcher rd=request.getRequestDispatcher("assignTeacher.jsp");
		rd.forward(request, response);
	}

}
