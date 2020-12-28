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

 
@WebServlet("/EditShow")
public class EditShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditShow() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		Items itemobj=new Items();
		itemobj.setID(request.getParameter("id"));
		UserDBLogic daoobj=new UserDBLogic();
		
		List<Items> itemlist=daoobj.fetchItemsByID(itemobj);
		request.setAttribute("ilist",itemlist);
		RequestDispatcher rd=request.getRequestDispatcher("Edit.jsp");
		rd.forward(request, response);
		  
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
