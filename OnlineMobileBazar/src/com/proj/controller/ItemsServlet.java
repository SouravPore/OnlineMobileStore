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

 
@WebServlet("/ItemsServlet")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ItemsServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String image=request.getParameter("image");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		Items itemobj=new Items(id,name,price,image,quantity);
		
		
		UserDBLogic daoobj=new UserDBLogic();
		boolean f=daoobj.ItemsStoreInDB(itemobj);
		
		if(f)
		{
			request.setAttribute("successmsg","Product Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("AddItems.jsp");
			 rd.forward(request, response);	
		}
		else
		{
			System.out.println("RECORD NOT INSERTED");
		}
		
		
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
