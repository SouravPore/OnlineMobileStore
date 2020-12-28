package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.UserDBLogic;
 
import com.proj.model.Items;
 
@WebServlet("/ItemsUpdate")
public class ItemsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ItemsUpdate() {
        super();
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Items itemobj=new Items();
		UserDBLogic daoobj=new UserDBLogic();
		
		itemobj.setID(request.getParameter("id"));
		itemobj.setName(request.getParameter("name")); 
		itemobj.setPrice(request.getParameter("price"));
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		itemobj.setQuantity(quantity); 
		
		boolean f=daoobj.itemsUpdate(itemobj);
		
		if(f)
		{
			request.setAttribute("successmsg","Product Updated Successfully");
			System.out.println("record Updated");
			RequestDispatcher rd=request.getRequestDispatcher("ViewItemsServlet");
			rd.forward(request, response);
		}
			
		else
			System.out.println("record not updated"); 
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
