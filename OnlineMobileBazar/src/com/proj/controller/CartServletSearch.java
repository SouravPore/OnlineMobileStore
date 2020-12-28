package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.UserDBLogic;
import com.proj.model.Items;

 
@WebServlet("/CartServletSearch")
public class CartServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public CartServletSearch() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Items itemobj=new Items();
		UserDBLogic daoobj=new UserDBLogic();
		itemobj.setID(request.getParameter("id"));
		List<Items> itemlist=daoobj.Cart(itemobj);
		 
		HttpSession session=request.getSession(true);
		 
		session.setAttribute("ilist",itemlist);
		response.sendRedirect("searchItem.jsp");
	}

		

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
