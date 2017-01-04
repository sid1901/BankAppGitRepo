<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>Spring MVC login example.</title> 
</head> 
<body> 
<h2>${message}</h2><br/> 
<jsp:include page="/index.jsp"></jsp:include> 
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
session.invalidate();
%>
 </body> 
</html>
