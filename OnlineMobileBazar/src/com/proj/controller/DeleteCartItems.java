package com.proj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDBLogic;


@WebServlet("/DeleteCartItems")
public class DeleteCartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteCartItems() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDBLogic daoobj=new UserDBLogic();
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		String id=request.getParameter("id");
		
		boolean f=daoobj.deleteCartItems(email, id);
		if(f)
		{
			System.out.println("Cart Item Deleted");
			response.sendRedirect("ViewCart");
		}
		else
		{
			System.out.println("Cart item not deleted");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
