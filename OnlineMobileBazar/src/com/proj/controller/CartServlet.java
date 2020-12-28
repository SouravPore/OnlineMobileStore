package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDBLogic;
import com.proj.model.Items;
import com.proj.model.UserItems;
 
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public CartServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDBLogic daoobj=new UserDBLogic();
		
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		String id=request.getParameter("id");
		Items itemobj=daoobj.fetchItemsBYID(id);
		
		String name=itemobj.getName();
		String image=itemobj.getImage();
		String price=itemobj.getPrice();
		 
		 UserItems uobj=new  UserItems(email,id,name,image,price);
		 
		 boolean f=daoobj.CartStoreInDB(uobj);
		 if(f)
		 {
			 System.out.println("Stored in Cart");
			 response.sendRedirect("HomeServlet");
		 }
		 else
		 {
			 System.out.println("Not stored in Cart");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
