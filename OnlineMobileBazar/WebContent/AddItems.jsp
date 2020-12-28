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
<a href="AdminAfterLogin.jsp">Back</a>
<form action="ItemsServlet" method="post">
<div class="container">
<div align="center">

<h1> Add Product</h1>

<div style="color:blue" >
		<%
			if(request.getAttribute("successmsg")!=null)
			{
			out.print(request.getAttribute("successmsg"));
			}
		%>
		 
		<br/>
		<br/>
	
</div>

<fieldset style="width:350px">
<br/>
<label for="id">Product ID :</label>
<input type="number" id="id" name="id" required="required"/>
<br/>
<br/>
<label for="name">Product Name :</label>
<input type="text" id="name" name="name" required="required"/>
<br/>
<br/>
<label for="price">Price :</label>
<input type="number" id="price" name="price" required="required"/>
<br/>
<br/>
<label for="image">Image :</label>
<input type="file" id="image" name="image" required="required"/>
<br/>
<br/>
<label for="quantity">Quantity :</label>
<input type="number" id="quantity" name="quantity" required="required"/>
<br/>
<br/>
</fieldset>
<br/>
<br/>

<input type="submit" value="Proccess">



</div>
</div>
</form>


</body>
</html>