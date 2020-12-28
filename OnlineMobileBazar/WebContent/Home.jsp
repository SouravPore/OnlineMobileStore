<%@ page import ="com.proj.model.Items" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Home Page</title>
</head>
<body>
<div class="container">
<div align="center"> 


			<jsp:include page="UserAfterLogin.jsp" />
		<br/>
<%
		if(request.getAttribute("ilist")!=null)
			{
		List<Items> ilist=(List<Items>)request.getAttribute("ilist");
		if(ilist.size()>0)
		{
	%>
	<%
	for(Items itemobj:ilist)
	{
		%>
		<fieldset style="width:200px">
		<br/>
		<img src="img/<%= itemobj.getImage() %>" width="140" height="170" class="imag-responsive">
		<br/>
		Rs. <%= itemobj.getPrice() %>
		<br/>
		<%= itemobj.getName() %>
		<br/>
		</fieldset>
		<br/>
		<form action="CartServlet" method="post">
					
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="Add to Cart"	class="btn btn-danger" style="color:blue;">		
				
				
				</form>
				<br/>
				<br/>

<% 			
			}
	%>
		 
		
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
 
</div>
</div>
</body>
</html>