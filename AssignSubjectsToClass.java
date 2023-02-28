package org.simplilearn.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.dao.GradeDao;
import org.simplilearn.dao.GradeDaoImpl;
import org.simplilearn.dao.SubjectClassTeacherDao;
import org.simplilearn.dao.SubjectClassTeacherDaoImpl;
import org.simplilearn.dao.SubjectDao;
import org.simplilearn.dao.SubjectDaoImpl;
import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.SubjectClassTeacher;


public class AssignSubjectsToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GradeDao gradeDao = new GradeDaoImpl();
	private SubjectDao subjectDao = new SubjectDaoImpl();
	private SubjectClassTeacherDao daoObj = new SubjectClassTeacherDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		String[] subjects = request.getParameterValues("subject");
				
		Grade gradeObj =gradeDao.get(grade);
		for(String str : subjects)
		{
			Subject sub = subjectDao.getSubject(Integer.parseInt(str));
			SubjectClassTeacher sub_class_teacher = new SubjectClassTeacher();
			sub_class_teacher.setGrade(gradeObj);
			sub_class_teacher.setSubject(sub);
			daoObj.insert(sub_class_teacher);
		}
		
		//gradeDao.assignSubject(gradeObj, subjects);
		
		
		request.setAttribute("msg", "Subjects Assigned To Class Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}

