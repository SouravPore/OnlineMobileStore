<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link href="CSS/regis.css" type="text/css" rel="stylesheet">
</head>
<body>

<a href="Index.jsp">Back</a>
<form action="UserRegServlet" method="post">

<div class="container">
<div align="center">
 <h1>Create A New Account</h1>
 
<fieldset style="width:350px">
 <br> 
 <label for="name">Name :</label> 
 <input type="text" id="name" name="name" required="required"/>
 <br> 
	<br>
   <label for="email">Email : </label>  
   <input type="email" id="email" name="email" autofocus="autofocus" required="required" placeholder="Enter Email"/> 
	<br> 
	<br>
	<label for="mobileno">Mobile No : </label>  
    <input type="number" id="mobileno" name="mobileno" required="required" placeholder="Enter your mobile no"/> 
	<br> 
	<br>
	<label for="password">Password : </label>  
    <input type="password" id="password" name="password" required="required"/> 
	<br> 
	<br>
	<label for="dob">Date Of Birth :</label>  
    <input type="date" id="dob" name="dob" required="required"/> 
	<br> 
	<br>
	<label for="ADDRESS">Address :</label>  
    <textarea rows="2" cols="20" name="address" required="required" placeholder="Enter your address"></textarea>  
	<br> 
	<br>
	<label for="gender">Gender : </label>  
    <input type="radio" id="gender" name="gender" value="Male" required="required"/>Male  
    <input type="radio" id="gender" name="gender" value="Female" required="required"/>Female 
     	   
   	<br> 
	<br>
	<label for="city">Select City :</label>  
    <select name="city" id="city" style="width:160px">  
        <option value="Kolkata">Kolkata</option>  
        <option value="Mumbai">Mumbai</option>  
        <option value="Delhi">Delhi</option>  
        <option value="Chennai">Chennai</option>
        <option value="Bangalore">Bangalore</option>  
        <option value="Other">Other</option>  
	</select>
	<br> 
	<br>
	<label for="pin">PIN No : </label>  
    <input type="tel" id="pin" name="pin" required="required" /> 

  <br>  <br> 
 </fieldset>
 <br>
 <br>
 	<input type="submit" value="REGISTER"> &nbsp; &nbsp;
	<input type="reset" value="RESET"> 
	  
 </div>
 </div> 
 </form>
 <br>
 <br>
 <div align="center">
 Already have an Account ~ <a href="UserLogin.jsp">Login</a>
 </div>
</body>
</html>