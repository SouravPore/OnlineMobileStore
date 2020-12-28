<%@ page import ="com.proj.model.UserInfo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/account.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="HomeServlet">Back</a>
<div class="container">
<div align="center">
	
<h1>Your Account</h1>
<div style="color:green" >
		<%
			if(request.getAttribute("successmsg")!=null)
			{
			out.print(request.getAttribute("successmsg"));
			}
		%>
		</div>
		<br><br>
		
	<%
		if(request.getAttribute("user")!=null)
			{
		UserInfo userobj=(UserInfo)request.getAttribute("user");
		
	%>
			
			<table border="1">
			<tr>
				<th>NAME</th>
				<th>EMAIL ID</th>
				<th>MOBILE NO</th>
				<th>PASSWORD</th>
				<th>DOB</th>
				<th>ADDRESS</th>
				<th>GENDER</th> 
				<th>CITY</th>
				<th>PIN</th>
			</tr>
	
	<%
			
		%>
			<tr>
				<td><%= userobj.getName() %></td>
				<td><%= userobj.getEmail() %></td>
				<td><%= userobj.getMobileno() %></td>
				<td><%= userobj.getPassword() %></td>
				<td><%= userobj.getDob() %></td>
				<td><%= userobj.getAddress() %></td>
				<td><%= userobj.getGender() %></td>
				<td><%= userobj.getCity() %></td>
				<td><%= userobj.getPIN() %></td>
 
				<td>
				 <form action="UserUpdateShow" method="post">
					
						<input type="hidden" name="email" value="<%=userobj.getEmail()%>">
						<input type="submit" value="EDIT"	class="btn btn-danger">	
						</form>	
				</td>			
				
			</tr>
	
		</table>
	<% 
			
		}
	%>
	
	
	</div>
</div>	

</body>
</html>