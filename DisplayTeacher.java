package org.simplilearn.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.dao.TeacherDao;
import org.simplilearn.dao.TeacherDaoImpl;
import org.simplilearn.lms.entities.Teacher;


public class DisplayTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TeacherDao dao = new TeacherDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teachers = dao.getAll();
		request.setAttribute("teachers", teachers);
		RequestDispatcher rd=request.getRequestDispatcher("displayTeacher.jsp");
		rd.forward(request, response);
	}

	

}

