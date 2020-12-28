<%@ page import ="com.proj.model.Items" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/search.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="HomeServlet">Back</a>
<div class="container" >
<div align="center">
<h1>Search Product</h1>
<form action="SearchItem">
 
 <font size=5 color=black >   <label for="name">Product Name : </label> </font> 
   <input type="text" id="name" name="name" autofocus="autofocus" required="required" placeholder="Enter name"/> 
	<br/> 
	<br/>
 
<p class="text-center">
<br/>
  <button type="submit" value="SEARCH" onclick="return checkBoxValidation()" class="btn btn-success btn-sm"><i class="fa fa-search"></i> Search</button>
                        </p>
	
</form>
<br/>
<br/>

<%
		if(request.getAttribute("ilist")!=null)
			{
		List<Items> ilist=(List<Items>)request.getAttribute("ilist");
		if(ilist.size()>0)
			{
	 
for(Items itemobj:ilist)
	{
	%>
		<img src="img/<%= itemobj.getImage() %>" width="80" height="100" class="imag-responsive">
		<br>
		Rs. <%= itemobj.getPrice() %>
		<br>
		<%= itemobj.getName() %>
		<br>
		<form action="CartServlet" method="post">
					
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="Add to Cart"	class="btn btn-danger">		
				
				
				</form>


  

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