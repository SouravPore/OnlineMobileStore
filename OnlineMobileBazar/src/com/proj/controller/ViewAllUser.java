package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.UserDBLogic;
import com.proj.model.Items;
import com.proj.model.UserInfo;

 
@WebServlet("/ViewAllUser")
public class ViewAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ViewAllUser() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		UserDBLogic daoobj=new UserDBLogic();
		List<UserInfo> userlist=daoobj.fetchUser();
		request.setAttribute("ilist", userlist);
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllUser.jsp");
		rd.forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
