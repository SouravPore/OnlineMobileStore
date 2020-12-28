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

 
@WebServlet("/UserUpdateShow")
public class UserUpdateShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public UserUpdateShow() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		
		UserDBLogic daoobj=new UserDBLogic();
		UserInfo userobj=daoobj.fetchDetail(email);
		request.setAttribute("user", userobj);
		RequestDispatcher rd=request.getRequestDispatcher("UserUpdate.jsp");
		rd.forward(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
