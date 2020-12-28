<%@ page import ="com.proj.model.BuyItems" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Items</title>
<link href="CSS/buyhis.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="HomeServlet">Back</a>
<div class="container">
<div align="center">
<h1>Shopping History</h1>
<br/>

<%
	     
	if(request.getAttribute("bilist")!=null)
		{
	List<BuyItems> ilist=(List<BuyItems>)request.getAttribute("bilist");
	if(ilist.size()>0)
	{
	%>
			
			<table border="1">
			<tr>
				 
				<th>NAME</th>
				<th>PRICE</th>
				<th>IMAGE</th>
				<th>DATE</th>
				 
			</tr>
	
	<%
	for(BuyItems itemobj:ilist)
	{
		%>
			<tr>
				 
				<td><%= itemobj.getName() %></td>
				<td> Rs. <%= itemobj.getPrice() %></td>
				<td><img src="img/<%= itemobj.getImage() %>" width="50" height="60" class="imag-responsive"></td> 
				<td><%= itemobj.getBuydate()%></td>	
				
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
			<h2 style="color: red;">You haven't buy anything</h2>
	<%
			}
		}
	%>

</div>
</div>


</body>
</html>