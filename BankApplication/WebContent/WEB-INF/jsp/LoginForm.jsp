<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Its hello2222</title>
</head>
<body>

 <form action="NewUser.html" method="POST"><br/>  
Enter user id <input type="text" name="uid"/><br/>  
New password <input type="password" name="pwd"/><br/>  
Confirm password <input type="password" name="cpwd"/><br/>  
First Name <input type="text" name="fname"/><br/>  
Last Name <input type="text" name="lname"/><br/>  
Address Line 1 <input type="text" name="add1"/><br/>  
Address Line 2 <input type="text" name="add2"/><br/>  
Mobile No. <input type="text" name="mob"/><br/>  
Email. <input type="text" name="email"/><br/>  
Age <input type="text" name="age"/><br/>  
Gender 
Male <input type="radio" value="male" name="gen"/>
Female <input type="radio" value="female" name="gen"/>
<input type= "submit" value="Submit"/>

</form>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%>
</body>
</html>