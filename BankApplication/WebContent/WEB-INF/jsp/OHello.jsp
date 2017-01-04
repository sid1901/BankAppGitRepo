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

   
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%> 
</body>
</html>