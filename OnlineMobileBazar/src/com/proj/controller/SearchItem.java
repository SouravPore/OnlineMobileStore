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
 

 
@WebServlet("/SearchItem")
public class SearchItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchItem() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		UserDBLogic daoobj=new UserDBLogic();
		String name=request.getParameter("name");
		List<Items> itemlist=daoobj.searchItem(name);
				
		request.setAttribute("ilist", itemlist);
		RequestDispatcher rd=request.getRequestDispatcher("searchItem.jsp");
		rd.forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
