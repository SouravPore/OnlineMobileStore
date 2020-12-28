package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDBLogic;
import com.proj.model.UserInfo;

 
@WebServlet("/UserLoginCheckServlet")
public class UserLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserLoginCheckServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDBLogic daoobj=new UserDBLogic();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserInfo userobj=daoobj.UserLoginCheck(email, password);
		if(userobj!=null)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("uinfo",userobj);
			session.setAttribute("email", email);
			System.out.println("VALID");
			response.sendRedirect("HomeServlet");
		}
		else
		{
			System.out.println("INVALID");
			request.setAttribute("errormsg", "Invalid Email or Password");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request, response);
			
		}
		
		
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
