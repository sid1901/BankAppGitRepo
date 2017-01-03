<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 

<title>Spring MVC login example.</title> 
</head> 
<body> 
<h2>${message}</h2><br/> 
<%-- <h2>${UserName}</h2><br/> --%>  

<a href="Services.html"> Click for new Service</a><br/>
<br/>
<br/>
	

<% 
String uid = (String) session.getAttribute("uid");
%>

Logged in id=<%=uid %>
<br/>
<br/>
   
<form action="Logout.html" method="post">
<input type="submit" value="Logout" >
</form>
 	
 	
</body> 
</html>