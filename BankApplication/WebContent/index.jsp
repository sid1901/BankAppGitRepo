<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking App</title>
</head>
<body>
	Welcome to Web based banking application </br>
	

	<%-- <%
	//invalidate the session if exists.
	session = request.getSession(false);
System.out.println("User="+session.getAttribute("user"));
if(session != null){
	session.invalidate();
}

%>
 --%>
 </br>
	<form action="Validate.html" method="POST">
		user id <input type="text" name="uid" /> </br>
		password <input type="password" name="pwd" /> </br>
		<a href="Forgot.html"> Forgot Password ?</a> </br>
		<input type="submit" value="Submit" />
</br>
	</form>
	<a href="Register.html"> Click for new user regiseration</a>
</body>
</html>