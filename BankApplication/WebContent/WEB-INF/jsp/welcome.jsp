<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 

<title>Spring MVC login example.</title> 
</head> 
<body> 
<h2>${message}</h2><br/> 
<%-- <h2>${UserName}</h2><br/> --%>  

<input type="button" id="services" value = "Services" onclick="location.href='/BankApplication/Services.html'" ></input></br>
<input type="button" id="profile" value = "Profile" onclick="location.href='/BankApplication/Profile.html'" ></input></br>
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
 	
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);

%> 	
</body> 
</html>