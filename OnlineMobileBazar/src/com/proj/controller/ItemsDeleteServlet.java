package com.proj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.UserDBLogic;
import com.proj.model.Items;
 

 
@WebServlet("/ItemsDeleteServlet")
public class ItemsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ItemsDeleteServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Items itemobj=new Items();
		itemobj.setID(request.getParameter("id"));
		 
		UserDBLogic daoobj=new UserDBLogic();
		boolean f=daoobj.itemsDelete(itemobj);
		 
		if(f)
		{
			request.setAttribute("successmsg","Item deleted");
			System.out.println("record deleted");
			response.sendRedirect("ViewItemsServlet");
		}
			
		else
			System.out.println("record not deleted");
	}
	

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
