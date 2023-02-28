package org.simplilearn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.dao.UserDao;
import org.simplilearn.dao.UserDaoImpl;
import org.simplilearn.lms.entities.User;


public class LoginController extends HttpServlet {
	
	private UserDao dao = new UserDaoImpl();
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = dao.get(username, password);
		
		if(user!=null)
		{
			HttpSession session1 = request.getSession();
			session1.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Invalid username or password!!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		

	}

}
