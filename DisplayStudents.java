package org.simplilearn.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.dao.StudentDao;
import org.simplilearn.dao.StudentDaoImpl;
import org.simplilearn.lms.entities.Student;


public class DisplayStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDaoImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> students = dao.getAll();
		request.setAttribute("students", students);
		RequestDispatcher rd=request.getRequestDispatcher("displayStudents.jsp");
		rd.forward(request, response);
		
	}

	

}