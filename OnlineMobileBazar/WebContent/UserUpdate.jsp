<%@ page import ="com.proj.model.UserInfo" %>
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

 <a href="ViewUserDetailServlet">Back</a>
<div class="container">
<div align="center">
<h1>Update your details</h1>
 <br>
 <br>
 
  <%
		if(request.getAttribute("user")!=null)
			{
		UserInfo userobj=(UserInfo)request.getAttribute("user");
		
	%>
 <form action="UserUpdate" method="post">
 
 <fieldset style="width:350px">
<br/><br/>
 <label for="name">Name :</label> 
 <input type="text" id="name" name="name" value='<%= userobj.getName() %>' required="required"/>

	<br/> 
	<br/>
	<label for="mobileno">Mobile No: </label>  
    <input type="number" id="mobileno" name="mobileno" value='<%= userobj.getMobileno() %>' required="required"/> 
	<br/> 
	<br/>
	<label for="password">Password: </label>  
    <input type="password" id="password" name="password" value='<%= userobj.getPassword() %>' required="required"/> 
	<br/> 
	<br/>
	<label for="dob">Date Of Birth:</label>  
    <input type="date" id="dob" name="dob" value='<%= userobj.getDob() %>' required="required"/> 
	<br/> 
	<br/>
	<label for="address">Address:</label>  
    <input type="text" name="address" value='<%= userobj.getAddress() %>' required="required"/>   
	<br/> 
	<br/>
	<label for="gender">Gender: </label>  
    <input type="radio" id="gender" name="gender" value="Male" required="required"/>Male  
    <input type="radio" id="gender" name="gender" value="Female" required="required"/>Female 
     	   
   	<br/> 
	<br/>
	<label for="city">Select City:</label>  
    <select name="city" id="city" style="width:160px">  
        <option value="Kolkata">Kolkata</option>  
        <option value="Mumbai">Mumbai</option>  
        <option value="Delhi">Delhi</option>  
        <option value="Chennai">Chennai</option>  
        <option value="Other">Other</option>  
	</select>
	<br/> 
	<br/>
	<label for="pin">PIN No: </label>  
    <input type="tel" id="pin" name="pin" value='<%= userobj.getPIN() %>' required="required" /> 
    <br>
    <br>
     </fieldset>
     <br><br>
     					<input type="hidden" name="email" value="<%=userobj.getEmail()%>">
						<input type="submit" value="UPDATE"	class="btn btn-danger"/>
						</form>
    <% 			
		}
	%>
    						
						


	 
	 
	
</div>
</div>
	
</body>
</html>