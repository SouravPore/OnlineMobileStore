<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN</title>
<link href="CSS/adminlogin.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="Index.jsp">Back</a>
<div class="container" >
<div align="center">

<h1>ADMIN LOGIN</h1>

<form action="AdminLoginCheckServlet" method="post">
<div style="color:red;">
		<%
			if(request.getAttribute("errormsg")!=null)
			out.print(request.getAttribute("errormsg"));
		%>
	   </div>
	   <br/>
<fieldset style="width:300px">
<br/><br/>

<label for="adminuid">ADMIN ID :</label>
<input type="text" id="adminuid" name="adminuid" required="required"/>
<br/>
<br/>
<label for="adminpass">PASSWORD :</label>
<input type="password" id="adminpass" name="adminpass" required="required"/>
<br/>
<br/>
</fieldset>
<br/><br/>
<input type="submit" value="Submit"/>&nbsp; &nbsp;
<input type="reset" value="Reset"/>

</form>
</div>
</div>

</body>
</html>