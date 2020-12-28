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
import com.proj.model.BuyItems;
import com.proj.model.Items;
import com.proj.model.UserInfo;
import com.proj.model.UserItems;

 
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		UserDBLogic daoobj=new UserDBLogic();
		BuyItems bobj=new BuyItems();
		
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		String id=request.getParameter("id");
		Items itemobj=daoobj.fetchItemsBYID(id);
		
		String name=itemobj.getName();
		String image=itemobj.getImage();
		String price=itemobj.getPrice();


		bobj.setEmail(email);
		bobj.setID(id);
		bobj.setName(name);
		bobj.setImage(image);
		bobj.setPrice(price);
		
		int i=daoobj.purchaseItems(bobj);
		if(i>0)
		{
			System.out.println("Item purchased");
			RequestDispatcher rd=request.getRequestDispatcher("Buy.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Not purchased");
		}
		
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
