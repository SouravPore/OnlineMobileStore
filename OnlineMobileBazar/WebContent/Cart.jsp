<%@ page import ="com.proj.model.UserItems" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/cart.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="HomeServlet">Back</a>
<div class="container">
<div align="center">

<h1>Your Cart </h1>

<div class="container">
<div align="center">
	
	 
	<%
	     
	if(request.getAttribute("ilist")!=null)
		{
	List<UserItems> ilist=(List<UserItems>)request.getAttribute("ilist");
	if(ilist.size()>0)
	{
	%>
			
			<table border="1">
			<tr>
				 
				<th>NAME</th>
				<th>PRICE</th>
				<th>IMAGE</th>
				 
			</tr>
	
	<%
	for(UserItems itemobj:ilist)
	{
		%>
			<tr>
				 
				<td><%= itemobj.getName() %></td>
				<td> Rs. <%= itemobj.getPrice() %></td>
				<td><img src="img/<%= itemobj.getImage() %>" width="50" height="60" class="imag-responsive"></td>
				
				 
 	
				 <td>
				 <form action="BuyServlet" method="post">
					
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="BUY"	class="btn btn-danger">	
				</form>	
				</td>	
				
				
				
					<td>
					<div style="color:red" >
				
					
				<form action="DeleteCartItems" method="post">
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="REMOVE"	class="btn btn-danger">					
					</form>
					</div>
				</td>	
				
				</tr>
	<% 			
			}
	%>
		</table>
		
	<% 
		    }
			else
			{
	%>
			<h2 style="color: red;">Cart is empty</h2>
	<%
			}
		}
	%>
	
</div>		
</div>	
</div>
</div>
</body>
</html>