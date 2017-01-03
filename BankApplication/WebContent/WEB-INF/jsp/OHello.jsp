<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Hello World</title>
 </head>
<body>
<% 
String uid = (String) session.getAttribute("uid");
%>
Logged in id=<%=uid %>
<br/>
<br/>

   <h2>${message}</h2>
<br/>
<br/>
   
<form action="Logout.html" method="post">
<input type="submit" value="Logout" >
</form>

   
 
</body>
</html>