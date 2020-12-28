<%@ page import ="com.proj.model.UserInfo" %>
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
	
	<h1>All Users</h1>

    <br><br>
	<%
		if(request.getAttribute("ilist")!=null)
			{
		List<UserInfo> ilist=(List<UserInfo>)request.getAttribute("ilist");
		if(ilist.size()>0)
		{
	%>
			 
			<table border="1">
			<tr>
				
				<th>NAME</th>
				<th>EMAIL</th>
				<th>MOBILE NO</th>
				<th>DOB</th>
				<th>ADDRESS</th>
				<th>GENDER</th>
				<th>CITY</th>
				<th>PIN</th>
				
			</tr>
	
	<%
	for(UserInfo userobj:ilist)
	{
		%>
			<tr>
				<td><%= userobj.getName() %></td>
				<td><%= userobj.getEmail() %></td>
				<td><%= userobj.getMobileno() %></td>
				<td><%= userobj.getDob() %></td>
				<td><%= userobj.getAddress() %></td>
				<td><%= userobj.getGender() %></td>
				<td><%= userobj.getCity() %></td>
				<td><%= userobj.getPIN() %></td>
				
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