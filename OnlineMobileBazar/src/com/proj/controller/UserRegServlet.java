package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.UserDBLogic;
import com.proj.model.UserInfo;


@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public UserRegServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserInfo userobj=new UserInfo();
		
		//String name=request.getParameter("name");
		//userobj.setName(name);
		
		userobj.setName(request.getParameter("name"));
		userobj.setEmail(request.getParameter("email"));
		userobj.setMobileno(request.getParameter("mobileno"));
		userobj.setAddress(request.getParameter("address")); 
		userobj.setPassword(request.getParameter("password")); 
		userobj.setDob(request.getParameter("dob"));
		userobj.setGender(request.getParameter("gender"));
		userobj.setCity(request.getParameter("city"));
		userobj.setPIN(request.getParameter("pin"));
		 
		UserDBLogic daoobj=new UserDBLogic();
		boolean f=daoobj.UserRegInfoStoreInDB(userobj);
		if(f)
		{
			
			request.setAttribute("successmsg","THANKS FOR REGISTRATION");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
			 rd.forward(request, response);	
		}
		else
			System.out.println("RECORD NOT INSERTED");
	}
	

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
