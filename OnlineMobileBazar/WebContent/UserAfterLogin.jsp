<%@page import="com.proj.model.UserInfo"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>After Login</title>
</head>
<body>
<%!UserInfo userobj;%>
	<%
		userobj=(UserInfo)session.getAttribute("uinfo");
	%>
	<div class="container">
		<div align="center">
		<br/>
			<jsp:include page="MenuBarUserAfterLogin.jsp" />
		<br/>
		 
		<br/>
		 
		<br/> 
		<h3 style="color:blue;">   Welcome   <%= userobj.getName() %></h3>
		</div>
	</div>
 
</body>
</html>