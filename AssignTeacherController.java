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
import org.simplilearn.dao.SubjectClassTeacherDao;
import org.simplilearn.dao.SubjectClassTeacherDaoImpl;
import org.simplilearn.dao.SubjectDao;
import org.simplilearn.dao.SubjectDaoImpl;
import org.simplilearn.dao.TeacherDao;
import org.simplilearn.dao.TeacherDaoImpl;
import org.simplilearn.lms.entities.Grade;
import org.simplilearn.lms.entities.SubjectClassTeacher;


public class AssignTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectClassTeacherDao dao = new SubjectClassTeacherDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int teacher = Integer.parseInt(request.getParameter("teacher"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		String[] subjects = request.getParameterValues("subject");
		
		List<SubjectClassTeacher> list = dao.getAll();
		
		for(SubjectClassTeacher obj : list)
		{
			if(obj.getGrade().getId() == grade )
			{
				for(String str : subjects)
				{
					if(obj.getSubject().getSub_id() == Integer.parseInt(str))
					{
						obj.setTeacher(teacherDao.get(teacher));
						dao.update(obj);
					}
				
				}
			}
		}
		
		request.setAttribute("msg", "Teacher Assigned Successfully!!!");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
