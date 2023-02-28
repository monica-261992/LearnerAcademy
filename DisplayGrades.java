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
import org.simplilearn.dao.StudentDao;
import org.simplilearn.dao.StudentDaoImpl;
import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.Student;

public class DisplayGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private GradeDao dao = new GradeDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Grade> grades = dao.getAll();
		request.setAttribute("grades", grades);
		RequestDispatcher rd=request.getRequestDispatcher("displayClass.jsp");
		rd.forward(request, response);
	}


}

