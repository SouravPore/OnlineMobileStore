<%@ page import ="com.proj.model.Items" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/buyhis.css" type="text/css" rel="stylesheet">
</head>
<body>

<a href="AdminAfterLogin.jsp">Back</a>
     
<div class="container">
<div align="center">
<font face= "comic sans ms">
	
	<h1>Products Detail</h1>
    <br><br>
    
    <div style="color:green" >
		<%
			if(request.getAttribute("successmsg")!=null)
			{
			out.print(request.getAttribute("successmsg"));
			}
		%>
		 
		</div>
    <br>
    <br>
    
	<%
		if(request.getAttribute("ilist")!=null)
			{
		List<Items> ilist=(List<Items>)request.getAttribute("ilist");
		if(ilist.size()>0)
		{
	%>
			 
			<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>IMAGE</th>
				<th>QUANTITY</th>
				<th>PURCHASES</th>
				 
			</tr>
	
	<%
	for(Items itemobj:ilist)
	{
		%>
			<tr>
				<td><%= itemobj.getID() %></td>
				<td><%= itemobj.getName() %></td>
				<td><%= itemobj.getPrice() %></td>
				<td><img src="img/<%= itemobj.getImage() %>" width="60" height="70" class="imag-responsive"></td>
				<td><%= itemobj.getQuantity() %></td>
				<td><%= itemobj.getPurchases() %></td>
				 
 	
				<td>
				 <form action="EditShow" method="post">
					
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="EDIT"	class="btn btn-danger">	
						</form>	
				</td>	
				
				
				
				
					<form action="ItemsDeleteServlet" method="post">
					
					 
				<td>	
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="DELETE"	class="btn btn-danger">					
					</form>
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
			<h2 style="color: red;">NO RECORD FOUND</h2>
	<%
			}
		}
	%>
	</font>
	</div>
</div>	

 
</body>
</html>