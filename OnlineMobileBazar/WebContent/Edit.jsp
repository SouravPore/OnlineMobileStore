<%@ page import ="com.proj.model.Items" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/editproduct.css" type="text/css" rel="stylesheet">
</head>
<body>
 
 <a href="ViewItemsServlet">Back</a>
 
<div class="container" >
<div align="center">
<h1>Edit Product</h1>
<br>
 
 
<%
		if(request.getAttribute("ilist")!=null)
			{
		List<Items> ilist=(List<Items>)request.getAttribute("ilist");
	 
for(Items itemobj:ilist)
	{
	%>
<form action="ItemsUpdate" method="post">

<fieldset style="width:350px">
<br/><br/>
	
<label for="id">Product ID</label>
<input type="number" id="id" name="id" value='<%= itemobj.getID() %>'/>
<br/>
<br/>
<label for="name">Product Name</label>
<input type="text" id="name" name="name" value='<%= itemobj.getName() %>'/>
<br/>
<br/>
<label for="price">Price</label>
<input type="number" id="price" name="price" value='<%= itemobj.getPrice() %>'/>
<br/>
<br/>
<label for="image">Image</label>
<img src="img/<%= itemobj.getImage() %>" width="70" height="90" class="imag-responsive">
<br/>
<br/>
<label for="quantity">Quantity</label>
<input type="number" id="quantity" name="quantity" value='<%= itemobj.getQuantity() %>'/>
<br/>
<br/>
</fieldset>
<br/>
<br/>
					
						<input type="hidden" name="id" value="<%=itemobj.getID()%>">
						<input type="submit" value="UPDATE"	class="btn btn-danger">	
						</form>	

<%
	}
}
%>
 
	
	  
 

</div>
</div>
 
</body>
</html>