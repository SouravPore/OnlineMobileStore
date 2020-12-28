<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin After Login</title>
<link href="CSS/adminafter.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
<div align="center">
<br/><br/><br/>
		 
		
		<a href="ViewAllUser">View Users</a> &nbsp; &nbsp; &nbsp; 
		
		<a href="">Delete Items</a> &nbsp; &nbsp; &nbsp; 
		
		<a href="AddItems.jsp" >Add Items</a> &nbsp; &nbsp; &nbsp;
		 
		<a href="ViewItemsServlet">View Products</a> &nbsp; &nbsp; &nbsp; 
		
		<a href="ViewAllBuyItems" >Purchased History</a> &nbsp; &nbsp; &nbsp; 
		
		 
		
		<a href="AdminLogoutServlet">LOGOUT</a>
		<br>
		<br>
		<div style="color:blue" >
		
		
		<h2>Admin Home</h2>
		<h1>
		
		<%
			if(request.getAttribute("successmsg")!=null)
			{
			out.print(request.getAttribute("successmsg"));
			}
		%>
		</h1>
		</div>
		</div>
		</div>
</body>
</html>