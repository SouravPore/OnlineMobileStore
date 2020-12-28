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

 
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewCart() {
        super();
         
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		UserItems uiobj=new UserItems();
		UserDBLogic daoobj=new UserDBLogic();
		 
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		List<UserItems> uilist=daoobj.CartShow(email);
		
		request.setAttribute("ilist", uilist);
		RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
		rd.forward(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
