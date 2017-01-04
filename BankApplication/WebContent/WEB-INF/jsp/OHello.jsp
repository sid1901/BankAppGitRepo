<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Banking Services</title>
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
   
<form action="Mobile.html" method="post">
<select name="Service11">
    <option value= "MB">Mobile Recharge</option>
    <option value="EB">Electricity Bill</option>
    <option value="DTH">DTH</option>
    <option value="Gas">GAS</option>
  </select>
  <br><br>

<input type="submit" value="Submit" >
</form>

   
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%> 
</body>
</html>