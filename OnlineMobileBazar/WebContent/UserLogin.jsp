<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link href="CSS/userlogin.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="Index.jsp">Back</a>
<div class="container">
<div align="center">
<h1>User Login</h1>

<div style="color:red" >
		<%
			if(request.getAttribute("successmsg")!=null)
			{
			out.print(request.getAttribute("successmsg"));
			}
		%>
		<% 
			if(request.getAttribute("errormsg")!=null)
			{
				out.print(request.getAttribute("errormsg"));
			}
			
		%>
		<br/>
		<br/>
		
</div>
</div>
</div>



<div class="container">
<div align="center">

<form action="UserLoginCheckServlet" method="post">
<fieldset style="width:300px">
<br/><br/>

<label for="email">User ID :</label>
<input type="email" id="email" name="email" required="required" placeholder="Enter ur Email" /> 
<br/>
<br/>
<label for="password" id="password">Password :</label>
<input type="password" id="password" name="password" required="required" placeholder="Enter password"/>
<br/>
<br/>
</fieldset>
<br/>
<br/>
<input type="submit" value="SUBMIT"/> &nbsp;
<input type="reset" value="RESET">
</form>
<br>
<br>
Don't have any Account~ <a href="UserRegistration.jsp">Sign Up</a>
</div>
</div>




</body>
</html>