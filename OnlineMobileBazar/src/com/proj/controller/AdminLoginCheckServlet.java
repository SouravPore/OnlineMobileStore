package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/AdminLoginCheckServlet")
public class AdminLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public AdminLoginCheckServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String adminuid=request.getParameter("adminuid");
		String adminpass=request.getParameter("adminpass");
		
		if(adminuid.equals("admin") && adminpass.equals("admin") ) {
			System.out.println("VALID");
			request.setAttribute("successmsg", "Welcome Admin");
			RequestDispatcher rd=request.getRequestDispatcher("AdminAfterLogin.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.println("INVALID");
			request.setAttribute("errormsg","Invalid Admin ID or Password");
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
	}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
