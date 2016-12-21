<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 

<title>Spring MVC login example.</title> 
</head> 
<body> 

<form action="index.jsp" method="post">
<input type="submit" value="Logout" >
</form>



<%-- <h2>${message}</h2> --%> 

<%
//allow access only if session exists
out.println("asdasd");
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("index.html");


}else {
	user = (String) session.getAttribute("user");
	 out.print("welcome " + user); 
}
%>


</body> 
</html>